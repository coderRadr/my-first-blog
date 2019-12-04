package net.codersadda.myblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.cryptocontrol.cryptonewsapi.CryptoControlApi;
import io.cryptocontrol.cryptonewsapi.models.Article;
import io.cryptocontrol.cryptonewsapi.models.Tweet;
import net.codersadda.myblog.entity.NewsResponse;
import net.codersadda.myblog.entity.Sources;

@Component
public class CryptoService {
	
	@Value("${crptonews.api.key}")
	private String cryptoKey;
	
	@Value("${crptonews.api.url}")
	private String cryptoUrl;
	
	public List<NewsResponse> getCryptoNews() {
		
		List<NewsResponse> responses = new ArrayList<>();
		
		CryptoControlApi api = new CryptoControlApi(cryptoKey);
		
		
		api.getTopNews(new CryptoControlApi.OnResponseHandler<List<Article>>() {
			public void onSuccess(List<Article> body) {
				NewsResponse response = new NewsResponse();
				response .setStatus("Crypto-News");
				List<Sources> sources = new ArrayList<>();
				for (Article article : body) {
					sources.add(new Sources(article.getTitle(), article.getDescription(), article.getUrl(), article.getCoins().get(0).getName(), "en"));
				}
				response.setSources(sources);
				responses.add(response);
			}
			
			
			public void onFailure(Exception e) {
				throw new ExceptionHandler(e.getLocalizedMessage());
			}
		});
		
		api.getLatestTweetsByCoin("bitcoin", new CryptoControlApi.OnResponseHandler<List<Tweet>>() {
			@Override public void onSuccess(List<Tweet> body) {
				NewsResponse response = new NewsResponse();
				response .setStatus("Tweets");
				List<Sources> sources = new ArrayList<>();
				for (Tweet post : body) {
					sources.add(new Sources(post.getMentions().toString(), post.getText(), post.getUrl(), post.getUsername(), "en"));
				}
				response.setSources(sources);
				responses.add(response);
			}
			
			
			@Override public void onFailure(Exception e) {
				throw new ExceptionHandler(e.getLocalizedMessage());
			}
		});
		return responses;
	}
}

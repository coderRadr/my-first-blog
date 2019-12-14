package net.codersadda.myblog.entity;

public class CurrentWeatherEntity {
	
	public double lat;
	public double lon;
	public double alt_m;
	public double alt_ft;
	public String wx_desc;
	public int wx_code;
	public String wx_icon;
	public double temp_c;
	public double temp_f;
	public double feelslike_c;
	public double feelslike_f;
	public int windspd_mph;
	public int windspd_kmh;
	public int windspd_kts;
	public double windspd_ms;
	public int winddir_deg;
	public String winddir_compass;
	public int cloudtotal_pct;
	public int humid_pct;
	public double dewpoint_c;
	public double dewpoint_f;
	public double vis_km;
	public double vis_mi;
	public int slp_mb;
	public double slp_in;
	public String cityName;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getAlt_m() {
		return alt_m;
	}
	public void setAlt_m(double alt_m) {
		this.alt_m = alt_m;
	}
	public double getAlt_ft() {
		return alt_ft;
	}
	public void setAlt_ft(double alt_ft) {
		this.alt_ft = alt_ft;
	}
	public String getWx_desc() {
		return wx_desc;
	}
	public void setWx_desc(String wx_desc) {
		this.wx_desc = wx_desc;
	}
	public int getWx_code() {
		return wx_code;
	}
	public void setWx_code(int wx_code) {
		this.wx_code = wx_code;
	}
	public String getWx_icon() {
		return wx_icon;
	}
	public void setWx_icon(String wx_icon) {
		this.wx_icon = wx_icon;
	}
	public double getTemp_c() {
		return temp_c;
	}
	public void setTemp_c(double temp_c) {
		this.temp_c = temp_c;
	}
	public double getTemp_f() {
		return temp_f;
	}
	public void setTemp_f(double temp_f) {
		this.temp_f = temp_f;
	}
	public double getFeelslike_c() {
		return feelslike_c;
	}
	public void setFeelslike_c(double feelslike_c) {
		this.feelslike_c = feelslike_c;
	}
	public double getFeelslike_f() {
		return feelslike_f;
	}
	public void setFeelslike_f(double feelslike_f) {
		this.feelslike_f = feelslike_f;
	}
	public int getWindspd_mph() {
		return windspd_mph;
	}
	public void setWindspd_mph(int windspd_mph) {
		this.windspd_mph = windspd_mph;
	}
	public int getWindspd_kmh() {
		return windspd_kmh;
	}
	public void setWindspd_kmh(int windspd_kmh) {
		this.windspd_kmh = windspd_kmh;
	}
	public int getWindspd_kts() {
		return windspd_kts;
	}
	public void setWindspd_kts(int windspd_kts) {
		this.windspd_kts = windspd_kts;
	}
	public double getWindspd_ms() {
		return windspd_ms;
	}
	public void setWindspd_ms(double windspd_ms) {
		this.windspd_ms = windspd_ms;
	}
	public int getWinddir_deg() {
		return winddir_deg;
	}
	public void setWinddir_deg(int winddir_deg) {
		this.winddir_deg = winddir_deg;
	}
	public String getWinddir_compass() {
		return winddir_compass;
	}
	public void setWinddir_compass(String winddir_compass) {
		this.winddir_compass = winddir_compass;
	}
	public int getCloudtotal_pct() {
		return cloudtotal_pct;
	}
	public void setCloudtotal_pct(int cloudtotal_pct) {
		this.cloudtotal_pct = cloudtotal_pct;
	}
	public int getHumid_pct() {
		return humid_pct;
	}
	public void setHumid_pct(int humid_pct) {
		this.humid_pct = humid_pct;
	}
	public double getDewpoint_c() {
		return dewpoint_c;
	}
	public void setDewpoint_c(double dewpoint_c) {
		this.dewpoint_c = dewpoint_c;
	}
	public double getDewpoint_f() {
		return dewpoint_f;
	}
	public void setDewpoint_f(double dewpoint_f) {
		this.dewpoint_f = dewpoint_f;
	}
	public double getVis_km() {
		return vis_km;
	}
	public void setVis_km(double vis_km) {
		this.vis_km = vis_km;
	}
	public double getVis_mi() {
		return vis_mi;
	}
	public void setVis_mi(double vis_mi) {
		this.vis_mi = vis_mi;
	}
	public int getSlp_mb() {
		return slp_mb;
	}
	public void setSlp_mb(int slp_mb) {
		this.slp_mb = slp_mb;
	}
	public double getSlp_in() {
		return slp_in;
	}
	public void setSlp_in(double slp_in) {
		this.slp_in = slp_in;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public CurrentWeatherEntity() {
		super();
	}
}

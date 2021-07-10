public class Job {
  private String id;
  private String type;
  private String url;
  private String createdAt;
  private String company;
  private String companyURL;
  private String location;
  private String title;
  private String description;
  private String howToApply;
  private String companyLogo;

  public Job(String id, String type, String url, String createdAt, String company,
      String companyURL, String location, String title, String description,
      String howToApply, String companyLogo) {
    this.id = id;
    this.type = type;
    this.url = url;
    this.createdAt = createdAt;
    this.company = company;
    this.companyURL = companyURL;
    this.location = location;
    this.title = title;
    this.description = description;
    this.howToApply = howToApply;
    this.companyLogo = companyLogo;
  }

  public String getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getUrl() {
    return url;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getCompany() {
    return company;
  }

  public String getCompanyURL() {
    return companyURL;
  }

  public String getLocation() {
    return location;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getHowToApply() {
    return howToApply;
  }

  public String getCompanyLogo() {
    return companyLogo;
  }
}

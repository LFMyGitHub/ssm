package demo.entity;

public class AuthorEntity {
    private String _id;
    private String name;
    private String headImageUrl;
    private String simpleIntro;
    private String detailIntro;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getSimpleIntro() {
        return simpleIntro;
    }

    public void setSimpleIntro(String simpleIntro) {
        this.simpleIntro = simpleIntro;
    }

    public String getDetailIntro() {
        return detailIntro;
    }

    public void setDetailIntro(String detailIntro) {
        this.detailIntro = detailIntro;
    }
}

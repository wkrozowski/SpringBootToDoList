package io.github.wkr1u18.hello.lang;

class LangDTO {

    private Integer id ;
    private String code;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LangDTO(Lang lang) {
        this.id = lang.getId();
        this.code = lang.getCode();
    }

}

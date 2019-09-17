package io.github.wkr1u18.hello.lang;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "languages" )
public class Lang {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id ;
    @Column(name="welcomemsg")
    private String welcomeMsg;
    private String code;

    /**
     * Hibernate uses it.
     */
    @SuppressWarnings("unused")
    public Lang() {

    }
    public Lang(Integer id, String welcomeMessage, String code) {
        this.id = id;
        this.welcomeMsg = welcomeMessage;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    void setWelcomeMsg(String welcomeMessage) {
        this.welcomeMsg = welcomeMessage;
    }

    public String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }
}

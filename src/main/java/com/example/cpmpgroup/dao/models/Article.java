package com.example.cpmpgroup.dao.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String designation;


    @NotNull
    private String unitee;

    @NotNull
    private String classe;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<ArticleUtilisee> bcassociation = new ArrayList<ArticleUtilisee>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<ArticleRealisee> articlesAttachees = new ArrayList<ArticleRealisee>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<ArticleRealiseeMC> articlesAttacheesMC = new ArrayList<ArticleRealiseeMC>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<OrdreDefinitif> articlesParOrdre = new ArrayList<OrdreDefinitif>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<MaterielLivreePro> materielsBCdeProjet = new ArrayList<MaterielLivreePro>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<MaterielleLivreeMC> materielsBCdeMC = new ArrayList<MaterielleLivreeMC>();

    public Article() {

    }

    public Article(String code, String designation, String unitee, String classe, List<ArticleUtilisee> bcassociation, Type type, List<ArticleRealisee> articlesAttachees, List<OrdreDefinitif> articlesParOrdre) {
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.classe = classe;
        this.bcassociation = bcassociation;
        this.type = type;
        this.articlesAttachees = articlesAttachees;
        this.articlesParOrdre = articlesParOrdre;
    }
}


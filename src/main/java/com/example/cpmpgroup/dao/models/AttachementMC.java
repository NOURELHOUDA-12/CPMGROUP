package com.example.cpmpgroup.dao.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attachementMC")
public class AttachementMC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String codeAttachementMC;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dateAttachementMC;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "attachementMC",cascade = CascadeType.REMOVE)
    private List<ArticleRealiseeMC> articlesAttacheesMC = new ArrayList<ArticleRealiseeMC>();


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordreTraveaux_id", nullable = false)
    private OrdreDeTraveaux ordreTraveaux;

}


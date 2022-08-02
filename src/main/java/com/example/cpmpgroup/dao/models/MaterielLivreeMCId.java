package com.example.cpmpgroup.dao.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class MaterielLivreeMCId  implements Serializable {
    Long  BonLivraisonMC_id;
    Long article_id;
}
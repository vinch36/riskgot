package com.vinch36.riskgot.model.game;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="risk_got_region")
public class Region {


    public Region(){

    }
    public Region(RegionNames pRegionName, int pBonus,Game pGame ){
        this.name = pRegionName;
        this.bonus=pBonus;
        this.game=pGame;
    }
    public enum RegionNames
    {
        NORD,CONFLANS, LES_ILES_DE_FER, VALE_DARRYN, TERRES_DE_LA_COURONNE, TERRES_DE_LOUEST, TERRES_DE_LORAGE, BIEF, DORNE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    private RegionNames name;

    private int bonus;

    @OneToMany(mappedBy="region")
    private List<Territory> territories;

    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id", nullable=false)
    @JsonBackReference("game_region")
    Game game;


}

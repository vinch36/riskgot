package com.vinch36.riskgot.model.game;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="risk_got_territory")

public class Territory {

    public enum TerritoryNames {
        //North (13)
        SKAGOS,DON,KARHOLD,FORT_TERREUR,WINTERFELL,ILE_AUX_OURS,BOIS_AUX_LOUPS,LA_VEUVE,BLANCPORT,TERTRES,ROCHES,NECK,CAP_KRAKEN,
        //RiverLands (5)
        LES_JUMEAUX,TRIDENT,VIVESAIGUES,HARRENHAL,PIERRE_MOUTIER,
        //Iron Islands (2)
        HARLOI,PYK,
        //Westerlands (5)
        FALAISE,LA_DENT_DOR,CASTRAL_ROC,MONTARGENT,CRAKENHALL,
        //Vale of Arryn (4)
        MONTAGNES_DE_LA_LUNE,DOIGTS,LES_EYRIE,GOEVILLE,
        //Crownlands (4)
        PRESQU_ILE_DE_CLAQUEPINCE,PORT_REAL,PEYREDRAGON,BOIS_DU_ROI,
        //StormLands (4)
        ACCALMIE,ILE_DE_TORTH,BOIS_LA_PLUIE,MARCHES_DE_DORNE,
        //Reach (7)
        ROUTE_DE_LOCEAN,NERA,MANDER,HAUTJARDIN,VILLEVIEILLE,TROIS_TOURS,LA_TREILLE,
        //Dorne (4)
        MONTAGNES_ROUGES,LE_GRES,SANG_VERT,LANCEHELION
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    TerritoryNames name;

    Boolean isCastle;

    Boolean isHarbor;

    @ManyToOne
    @JoinColumn(name="region_id",referencedColumnName = "id", nullable=false)
    Region region;

    //@OneToMany
    //List<Territory> connectedTerritories;

    @OneToOne(mappedBy="capitalTerritory")
    Family capitalOf;

    @ManyToOne
    @JoinColumn(name="player_id",referencedColumnName = "id", nullable=false)
    Player owningPlayer;

    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id", nullable=false)
    Game game;


    Integer armies;





}

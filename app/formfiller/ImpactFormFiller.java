package formfiller;

public class ImpactFormFiller extends FormFiller{

    private static final Object[][] checkboxes = {
            {"dossier.existant",                                         0, 40, 60},
            {"dossier.fin_droit",                                        1, 63, 753},
            {"dossier.logement",                                         1, 63, 661},
            {"dossier.etablissement",                                    1, 63, 638},
            {"dossier.ecole",                                            1, 63, 615},
            {"dossier.travail",                                          1, 322, 661},
            {"dossier.formation",                                        1, 322, 638},

            {"demandeur.masculin",                                       1, 167, 410},
            {"demandeur.feminin",                                        1, 255, 410},
            {"demandeur.francais",                                       1, 167, 330},
            {"demandeur.ue",                                             1, 258, 330},
            {"demandeur.autre",                                          1, 382, 330},

            {"demandeur.contact.email",                                  1, 312, 140},
            {"demandeur.contact.appel",                                  1, 370, 140},
            {"demandeur.contact.sms",                                    1, 453, 140},
            {"demandeur.contact.courrier",                               1, 500, 140},

            {"demandeur.prestations.CAF",                                1, 169, 73},
            {"demandeur.prestations.MSA",                                1, 230, 73},
            {"demandeur.prestations.autre",                              1, 290, 73},

            {"parent1",                                                  2, 231, 735},
            {"parent2",                                                  2, 438, 735},

            {"aide.quotidienne.proche",                                  2, 227, 430},
            {"aide.quotidienne.association",                             2, 320, 430},
            {"aide.quotidienne.autre",                                   2, 435, 430},

            {"aide.ponctuelle.tuteur",                                   2, 260, 230},
            {"aide.ponctuelle.curateur",                                 2, 328, 230},
            {"aide.pontuelle.autre",                                     2, 405, 230},

            {"vie_quotidienne.vie.seul",                                 3, 56, 660},
            {"vie_quotidienne.vie.enfants",                              3, 200, 660},
            {"vie_quotidienne.vie.etablissement",                        3, 320, 660},
            {"vie_quotidienne.vie.parents",                              3, 56, 640},
            {"vie_quotidienne.vie.couple",                               3, 200, 640},
            {"vie_quotidienne.vie.autre",                                3, 56, 598},

            {"vie_quotidienne.logement.independant",                     3, 56, 548},
            {"vie_quotidienne.logement.independant.proprietaire",        3, 136, 530},
            {"vie_quotidienne.logement.independant.locataire",           3, 218, 530},
            {"vie_quotidienne.logement.parents",                         3, 320, 548},
            {"vie_quotidienne.logement.enfants",                         3, 432, 548},
            {"vie_quotidienne.logement.ami",                             3, 320, 525},
            {"vie_quotidienne.logement.famille",                         3, 432, 525},
            {"vie_quotidienne.logement.accueil",                         3, 320, 503},
            {"vie_quotidienne.logement.autre",                           3, 56, 470},

            {"vie_quotidienne.aide_argent",                              3, 56, 393},
            {"vie_quotidienne.aide_personne",                            3, 56, 342},
            {"vie_quotidienne.aide_personne.famille",                    3, 180, 352},
            {"vie_quotidienne.aide_personne.pro",                        3, 280, 352},
            {"vie_quotidienne.aide_personne.accompagement",              3, 405, 352},
            {"vie_quotidienne.aide_personne.autre",                      3, 180, 332},
            {"vie_quotidienne.aide_materiel",                            3, 56, 275},
            {"vie_quotidienne.aide_materiel.logement",                   3, 180, 297},
            {"vie_quotidienne.aide_materiel.vehicule",                   3, 333, 297},
            {"vie_quotidienne.aide_materiel.animal",                     3, 448, 299},
            {"vie_quotidienne.aide_materiel.technique",                  3, 180, 275},
            {"vie_quotidienne.aide_materiel.autre",                      3, 180, 252},

            {"besoin.vie_quotidienne.depenses_courantes",                4, 56, 529},
            {"besoin.vie_quotidienne.preparer_repas",                    4, 318, 529},
            {"besoin.vie_quotidienne.budget",                            4, 56, 500},
            {"besoin.vie_quotidienne.prendre_repas",                     4, 318, 500},
            {"besoin.vie_quotidienne.hygiene",                           4, 56, 472},
            {"besoin.vie_quotidienne.menage",                            4, 318, 472},
            {"besoin.vie_quotidienne.habiller",                          4, 56, 447},
            {"besoin.vie_quotidienne.sante",                             4, 318, 445},
            {"besoin.vie_quotidienne.courses",                           4, 56, 422},
            {"besoin.vie_quotidienne.autre",                             4, 56, 392},

            {"besoin.deplacement.domicile.interieur",                    4, 56, 312},
            {"besoin.deplacement.vehicule",                              4, 318, 312},
            {"besoin.deplacement.domicile.acces",                        4, 56, 292},
            {"besoin.deplacement.transports",                            4, 318, 292},
            {"besoin.deplacement.domicile.exterieur",                    4, 56, 272},
            {"besoin.deplacement.vacances",                              4, 318, 272},
            {"besoin.deplacement.transports.oui",                        4, 405, 240},
            {"besoin.deplacement.transports.non",                        4, 460, 240},
            {"besoin.deplacement.autre",                                 4, 56, 215},

            {"besoin.vie_sociale.communiquer",                           4, 56, 140},
            {"besoin.vie_sociale.famille",                               4, 320, 140},
            {"besoin.vie_sociale.activites",                             4, 56, 118},
            {"besoin.vie_sociale.citoyen",                               4, 320, 118},
            {"besoin.vie_sociale.relations",                             4, 56, 95},
            {"besoin.vie_sociale.securite",                              4, 320, 95},
            {"besoin.vie_sociale.autre",                                 4, 56, 60},

            {"attente.domicile",                                         5, 56, 652},
            {"attente.aide_technique",                                   5, 233, 652},
            {"attente.etablissement",                                    5, 390, 652},
            {"attente.revenu_min",                                       5, 56, 622},
            {"attente.amenagement",                                      5, 233, 622},
            {"attente.depenses",                                         5, 390, 622},
            {"attente.aide_humaine",                                     5, 56, 590},
            {"attente.aide_mobilite",                                    5, 233, 590},
            {"attente.autre",                                            5, 56, 550},

            {"attente.structure_identifiee.oui",                         5, 440, 507},
            {"attente.structure_identifiee.non",                         5, 495, 507},
            {"attente.structure1.oui",                                   5, 440, 458},
            {"attente.structure1.non",                                   5, 495, 458},
            {"attente.structure2.oui",                                   5, 440, 432},
            {"attente.structure2.non",                                   5, 495, 432},

            {"attente.stationnement",                                    5, 90, 340},
            {"attente.invalidite",                                       5, 337, 340},
            {"attente.aucune",                                           5, 90, 300},

            {"vie_quotidienne.justificatifs",                            6, 55, 312},
            {"vie_quotidienne.reduction_activite_pro",                   6, 55, 280},
            {"vie_quotidienne.tierce_personne",                          6, 55, 243},
            {"vie_quotidienne.pension_invalidite",                       6, 55, 212},

            {"vie_scolaire.situation.ordinaire",                         7, 55, 654},
            {"vie_scolaire.situation.domicile",                          7, 55, 630},
            {"vie_scolaire.situation.internat",                          7, 55, 606},
            {"vie_scolaire.situation.etablissement_ft",                  7, 55, 580},
            {"vie_scolaire.situation.etablissement_ht",                  7, 55, 554},
            {"vie_scolaire.situation.superieur",                         7, 55, 528},
            {"vie_scolaire.situation.internat.frais.oui",                7, 423, 497},
            {"vie_scolaire.situation.internat.frais.non",                7, 475, 497},
            {"vie_scolaire.situation.autre.",                            7, 55, 470},
            {"vie_scolaire.situation.non_scolarise.age",                 7, 55, 403},
            {"vie_scolaire.situation.non_scolarise.etablissement",       7, 325, 403},
            {"vie_scolaire.situation.non_scolarise.autre",               7, 55, 295},

            {"vie_scolaire.GEVAsco",                                     7, 73, 149},
            {"vie_scolaire.attente.etablissement_identifie.contact.oui", 7, 328, 70},
            {"vie_scolaire.attente.etablissement_identifie.contact.non", 7, 382, 70},

            {"vie_pro.situation.emploi",                                 9, 55, 685},
            {"vie_pro.situation.emploi.adapte",                          9, 55, 640},
            {"vie_pro.situation.emploi.ordinaire",                       9, 183, 640},
            {"vie_pro.situation.emploi.esat",                            9, 55, 620},

            {"vie_pro.situation.emploi.type.CDI",                        9, 55, 558},
            {"vie_pro.situation.emploi.type.CDD",                        9, 100, 558},
            {"vie_pro.situation.emploi.type.interim",                    9, 153, 558},
            {"vie_pro.situation.emploi.type.aide",                       9, 210, 558},
            {"vie_pro.situation.emploi.type.independant",                9, 55, 535},
            {"vie_pro.situation.emploi.complet",                         9, 53, 287},
            {"vie_pro.situation.emploi.partiel",                         9, 130, 287},
            {"vie_pro.situation.emploi.adapte.oui",                      9, 195, 246},
            {"vie_pro.situation.emploi.adapte.non",                      9, 240, 246},
            {"vie_pro.situation.emploi.amenagements",                    9, 53, 123},

            {"vie_pro.situation.sans_emploi",                            9, 318, 685},
            {"vie_pro.situation.sans_emploi.deja_travaille.oui",         9, 465, 640},
            {"vie_pro.situation.sans_emploi.deja_travaille.non",         9, 508, 640},
            {"vie_pro.situation.sans_emploi.inscrit_pole_emploi",        9, 318, 427},
            {"vie_pro.situation.sans_emploi.formation",                  9, 318, 405},
            {"vie_pro.situation.sans_emploi.etudiant",                   9, 460, 405},
            {"vie_pro.situation.sans_emploi.stage",                      9, 318, 340},
            {"vie_pro.situation.sans_emploi.remunere.oui",               9, 380, 323},
            {"vie_pro.situation.sans_emploi.remunere.non",               9, 422, 323},
            {"vie_pro.situation.sans_emploi.mission_locale",             9, 318, 203},
            {"vie_pro.situation.sans_emploi.pole_emploi",                9, 425, 203},
            {"vie_pro.situation.sans_emploi.cap_emploi",                 9, 318, 175},
            {"vie_pro.situation.sans_emploi.rsa",                        9, 425, 175},
            {"vie_pro.situation.sans_emploi.sameth",                     9, 318, 143},
            {"vie_pro.situation.sans_emploi.autre",                      9, 318, 103},

            {"vie_pro.situation.arret",                                  10, 55, 685},
            {"vie_pro.situation.arret.maladie_indemnites",               10, 55, 643},
            {"vie_pro.situation.arret.accident",                         10, 308, 643},
            {"vie_pro.situation.arret.maladie_sans_indemnites",          10, 55, 620},
            {"vie_pro.situation.arret.maternite",                        10, 308, 620},

            {"vie_pro.situation.fiche_medecin",                          10, 103, 584},
            {"vie_pro.situation.rencontre_carsat.non",                   10, 308, 550},
            {"vie_pro.situation.rencontre_carsat.oui",                   10, 368, 550},
            {"vie_pro.situation.visite_pre-reprise.non",                 10, 308, 516},
            {"vie_pro.situation.visite_pre-reprise.oui",                 10, 368, 516},

            {"vie_pro.situation.prestation.AAH",                         10, 55, 443},
            {"vie_pro.situation.prestation.RSA",                         10, 297, 443},
            {"vie_pro.situation.prestation.chomage",                     10, 55, 420},
            {"vie_pro.situation.prestation.AGEFIPH",                     10, 297, 420},
            {"vie_pro.situation.prestation.ASS",                         10, 55, 397},
            {"vie_pro.situation.prestation.FIPHFP",                      10, 297, 387},
            {"vie_pro.situation.prestation.retraite",                    10, 55, 375},
            {"vie_pro.situation.prestation.invalidite",                  10, 55, 344},
            {"vie_pro.situation.prestation.invalidite.1",                10, 198, 344},
            {"vie_pro.situation.prestation.invalidite.2",                10, 278, 344},
            {"vie_pro.situation.prestation.invalidite.autre",            10, 55, 320},
            {"vie_pro.situation.prestation.MTP.oui",                     10, 198, 295},
            {"vie_pro.situation.prestation.MTP.non",                     10, 245, 295},
            {"vie_pro.situation.prestation.invalidite.justificatif",     10, 102, 267},
            {"vie_pro.situation.prestation.rente",                       10, 102, 243},
            {"vie_pro.situation.prestation.RQTH.oui",                    10, 444, 211},
            {"vie_pro.situation.prestation.RQTH.non",                    10, 496, 211},
            {"vie_pro.situation.prestation.autre",                       10, 55, 182},

            {"vie_pro.situation.retraite",                               10, 55, 145},
            {"vie_pro.situation.retraite.aspa.oui",                      10, 265, 94},
            {"vie_pro.situation.retraite.aspa.non",                      10, 305, 94},
            {"vie_pro.situation.retraite.pension.oui",                   10, 265, 67},
            {"vie_pro.situation.retraite.pension.non",                   10, 305, 67},

            {"vie_pro.parcours.qualification.primaire",                  11, 55, 398},
            {"vie_pro.parcours.qualification.secondaire",                11, 120, 398},
            {"vie_pro.parcours.qualification.superieur",                 11, 195, 398},

            {"vie_pro.projet_pro.soutien.bilan",                         12, 55, 472},
            {"vie_pro.projet_pro.soutien.acces_emploi",                  12, 320, 472},
            {"vie_pro.projet_pro.soutien.projet_pro_detail",             12, 55, 450},
            {"vie_pro.projet_pro.soutien.acces_formation",               12, 320, 450},
            {"vie_pro.projet_pro.soutien.adapter_environnement",         12, 55, 422},
            {"vie_pro.projet_pro.soutien.structure.contact.oui",         12, 330, 358},
            {"vie_pro.projet_pro.soutien.structure.contact.non",         12, 385, 358},

            {"aidant.situation.vit_avec_psh.non",                        13, 275, 550},
            {"aidant.situation.vit_avec_psh.oui",                        13, 327, 550},
            {"aidant.situation.emploi.oui",                              13, 275, 528},
            {"aidant.situation.emploi.non",                              13, 327, 528},
            {"aidant.situation.emploi.reduction",                        13, 380, 528},

            {"aidant.aide_apportee.surveillance",                        13, 55, 456},
            {"aidant.aide_apportee.coordination_pros",                   13, 315, 456},
            {"aidant.aide_apportee.deplacement_int",                     13, 55, 436},
            {"aidant.aide_apportee.gestion_admin",                       13, 315, 436},
            {"aidant.aide_apportee.deplacement_ext",                     13, 55, 416},
            {"aidant.aide_apportee.gestion_financiere",                  13, 315, 416},
            {"aidant.aide_apportee.entretien",                           13, 55, 393},
            {"aidant.aide_apportee.activites",                           13, 315, 393},
            {"aidant.aide_apportee.hygiene",                             13, 55, 371},
            {"aidant.aide_apportee.communication",                       13, 315, 371},
            {"aidant.aide_apportee.preparation_repas",                   13, 55, 349},
            {"aidant.aide_apportee.suivi_medical",                       13, 315, 349},
            {"aidant.aide_apportee.prise_repas",                         13, 55, 329},
            {"aidant.aide_apportee.autre",                               13, 55, 303},

            {"aidant.dedommagement.oui",                                 13, 55, 243},
            {"aidant.dedommagement.non",                                 13, 315, 243},

            {"aidant.participant.professionel",                          13, 55, 180},
            {"aidant.participant.proche",                                13, 193, 180},
            {"aidant.participant.aucun",                                 13, 380, 180},

            {"aidant.soutien.aucun",                                     13, 55, 107},
            {"aidant.soutien.rencontres",                                13, 193, 107},
            {"aidant.soutien.individuel",                                13, 380, 107},

            {"aidant.remplacement.oui",                                  13, 315, 75},
            {"aidant.remplacement.non",                                  13, 315, 55},

            {"aidant.futur.eloignement_geo",                             14, 56, 700},
            {"aidant.futur.probleme_sante",                              14, 323, 700},
            {"aidant.futur.indisponibilite",                             14, 56, 678},
            {"aidant.futur.changement_vie_pro",                          14, 323, 678},
            {"aidant.futur.changement_vie_perso",                        14, 56, 653},
            {"aidant.futur.autre",                                       14, 56, 613},

            {"aidant.dispositifs.aidant",                                14, 56, 550},
            {"aidant.dispositifs.psh",                                   14, 140, 550},
            {"aidant.dispositifs.autre",                                 14, 56, 520},

            {"aidant.attentes.repos",                                    14, 56, 420},
            {"aidant.attentes.aide_financiere",                          14, 310, 420},
            {"aidant.attentes.imprevu",                                  14, 56, 397},
            {"aidant.attentes.echanges_aidant",                          14, 310, 397},
            {"aidant.attentes.vacances",                                 14, 56, 375},
            {"aidant.attentes.soutien_psycho",                           14, 310, 375},
            {"aidant.attentes.vie_pro",                                  14, 56, 353},
            {"aidant.attentes.conseil",                                  14, 310, 353},
            {"aidant.attentes.vie_sociale",                              14, 56, 330},
            {"aidant.attentes.assurance_vieillesse",                     14, 310, 330},
            {"aidant.attentes.autre",                                    14, 56, 298},

            {"demande.signature.psh",                                    15, 126, 488},
            {"demande.signature.representant",                           15, 282, 488},
            {"demande.signature.parent",                                 15, 448, 488},

            {"demande.MDPH_echange_pro.oui",                             15, 42, 385},
            {"demande.MDPH_echange_pro.non",                             15, 330, 385},
            {"demande.certification_honneur",                            15, 42, 307},

    };

    private static final Object[][] textFields = {
            {"dossier.numero",                                                  0, 400, 60},

            {"dossier.fin_droit.1",                                             1, 120, 730},
            {"dossier.fin_droit.2",                                             1, 120, 710},
            {"dossier.fin_droit.3",                                             1, 120, 690},

            {"dossier.difficulté",                                              1, 63, 572},

            {"demandeur.nom",                                                   1, 167, 390},
            {"demandeur.nom_usage",                                             1, 167, 370},
            {"demandeur.prenom",                                                1, 167, 350},
            {"demandeur.lieu_naissance",                                        1, 167, 310},
            {"demandeur.pays",                                                  1, 167, 290},
            {"demandeur.autre.label",                                           1, 440, 327},
            {"demandeur.adresse",                                               1, 167, 245},
            {"demandeur.adresse.complement",                                    1, 167, 225},
            {"demandeur.adresse.commune",                                       1, 167, 205},
            {"demandeur.adresse.pays",                                          1, 440, 205},
            {"demandeur.email.gauche",                                          1, 167, 160},
            {"demandeur.email.droite",                                          1, 365, 160},
            {"demandeur.organisme",                                             1, 167, 120},

            {"parent1.nom",                                                     2, 175, 700},
            {"parent1.prenom",                                                  2, 175, 677},
            {"parent1.adresse.rue",                                             2, 175, 658},
            {"parent1.adresse.complement",                                      2, 175, 638},
            {"parent1.adresse.commune",                                         2, 175, 600},
            {"parent1.adresse.email",                                           2, 175, 560},

            {"parent2.nom",                                                     2, 375, 700},
            {"parent2.prenom",                                                  2, 375, 677},
            {"parent2.adresse.rue",                                             2, 375, 658},
            {"parent2.adresse.complement",                                      2, 375, 638},
            {"parent2.adresse.commune",                                         2, 375, 600},
            {"parent2.adresse.email",                                           2, 375, 560},

            {"aide.quotidienne.adresse.nom",                                    2, 175, 393},
            {"aide.quotidienne.adresse.rue",                                    2, 175, 372},
            {"aide.quotidienne.adresse.complement",                             2, 175, 351},
            {"aide.quotidienne.adresse.commune",                                2, 175, 311},
            {"aide.quotidienne.adresse.email",                                  2, 175, 272},

            {"aide.ponctuelle.adresse.organisme",                               2, 175, 192},
            {"aide.ponctuelle.adresse.nom",                                     2, 175, 172},
            {"aide.ponctuelle.adresse.rue",                                     2, 175, 152},
            {"aide.ponctuelle.adresse.complement",                              2, 175, 132},
            {"aide.ponctuelle.adresse.commune",                                 2, 175, 92},
            {"aide.ponctuelle.adresse.email",                                   2, 175, 52},

            {"vie_quotidienne.vie.etablissement.detail",                        3, 320, 640},
            {"vie_quotidienne.vie.autre.detail",                                3, 200, 598},

            {"vie_quotidienne.logement.autre.detail",                           3, 200, 472},

            {"vie_quotidienne.aide_argent.revenu",                              3, 370, 402},
            {"vie_quotidienne.aide_argent.depenses",                            3, 370, 383},
            {"vie_quotidienne.aide_personne.autre",                             3, 245, 332},
            {"vie_quotidienne.aide_materiel.technique.detail",                  3, 333, 275},
            {"vie_quotidienne.aide_materiel.autre.detail",                      3, 245, 252},

            {"vie_quotidienne.frais1",                                          3, 10, 120},
            {"vie_quotidienne.frais1.frequence",                                3, 185, 120},
            {"vie_quotidienne.frais1.total",                                    3, 260, 120},
            {"vie_quotidienne.frais1.rembourse",                                3, 333, 120},
            {"vie_quotidienne.frais1.detail",                                   3, 410, 120},

            {"vie_quotidienne.frais2",                                          3, 10, 100},
            {"vie_quotidienne.frais2.frequence",                                3, 185, 100},
            {"vie_quotidienne.frais2.total",                                    3, 260, 100},
            {"vie_quotidienne.frais2.rembourse",                                3, 333, 100},
            {"vie_quotidienne.frais2.detail",                                   3, 410, 100},

            {"vie_quotidienne.frais3",                                          3, 10, 80},
            {"vie_quotidienne.frais3.frequence",                                3, 185, 80},
            {"vie_quotidienne.frais3.total",                                    3, 260, 80},
            {"vie_quotidienne.frais3.rembourse",                                3, 333, 80},
            {"vie_quotidienne.frais3.detail",                                   3, 410, 80},

            {"vie_quotidienne.frais4",                                          3, 10, 60},
            {"vie_quotidienne.frais4.frequence",                                3, 185, 60},
            {"vie_quotidienne.frais4.total",                                    3, 260, 60},
            {"vie_quotidienne.frais4.rembourse",                                3, 333, 60},
            {"vie_quotidienne.frais4.detail",                                   3, 410, 60},

            {"besoin.vie_quotidienne.autre",                                    4, 190, 392},

            {"besoin.deplacement.autre",                                        4, 190, 215},

            {"besoin.vie_sociale.autre",                                        4, 190, 60},

            {"attente.autre",                                                   5, 190, 550},
            {"attente.structure1",                                              5, 130, 455},
            {"attente.structure2",                                              5, 130, 435},

            {"vie_quotidienne.renseignements",                                  6, 50, 715},

            {"vie_scolaire.situation.etablissement.liste",                      7, 323, 630},
            {"vie_scolaire.situation.autre.detail",                             7, 150, 470},
            {"vie_scolaire.situation.non_scolarise.age.date",                   7, 55, 370},
            {"vie_scolaire.situation.non_scolarise.etablissement.detail",       7, 325, 370},
            {"vie_scolaire.situation.non_scolarise.autre.detail",               7, 150, 300},
            {"vie_scolaire.attente.etablissement_identifie",                    7, 326, 115},
            {"vie_scolaire.attente.autre",                                      8, 50, 695},

            {"vie_pro.situation.emploi.type.independant.regime",                9, 150, 535},
            {"vie_pro.situation.emploi.employeur.nom",                          9, 120, 468},
            {"vie_pro.situation.emploi.employeur.adresse",                      9, 120, 447},
            {"vie_pro.situation.emploi.employeur.service",                      9, 55, 390},
            {"vie_pro.situation.emploi.employeur.poste",                        9, 120, 318},
            {"vie_pro.situation.emploi.adapte.non.detail",                      9, 121, 230},
            {"vie_pro.situation.emploi.difficultes",                            9, 55, 195},
            {"vie_pro.situation.emploi.amenagements.detail",                    9, 55, 105},

            {"vie_pro.situation.sans_emploi.raison",                            9, 318, 575},
            {"vie_pro.situation.sans_emploi.detail",                            9, 370, 385},
            {"vie_pro.situation.sans_emploi.organisme",                         9, 391, 293},
            {"vie_pro.situation.sans_emploi.detail",                            9, 318, 87},

            {"vie_pro.situation.prestation.invalidite.autre.detail",            10, 248, 320},
            {"vie_pro.situation.prestation.autre.detail",                       10, 150, 182},

            {"vie_pro.parcours.1.poste",                                        11, 143, 615},
            {"vie_pro.parcours.1.entreprise",                                   11, 245, 615},
            {"vie_pro.parcours.1.motif",                                        11, 420, 615},
            {"vie_pro.parcours.2.poste",                                        11, 143, 572},
            {"vie_pro.parcours.2.entreprise",                                   11, 245, 572},
            {"vie_pro.parcours.2.motif",                                        11, 420, 572},
            {"vie_pro.parcours.3.poste",                                        11, 143, 528},
            {"vie_pro.parcours.3.entreprise",                                   11, 245, 528},
            {"vie_pro.parcours.3.motif",                                        11, 420, 528},
            {"vie_pro.parcours.4.poste",                                        11, 143, 485},
            {"vie_pro.parcours.4.entreprise",                                   11, 245, 485},
            {"vie_pro.parcours.4.motif",                                        11, 420, 485},

            {"vie_pro.parcours.qualification.classe",                           11, 183, 363},

            {"vie_pro.parcours.formation.1",                                    11, 320, 373},
            {"vie_pro.parcours.formation.2",                                    11, 320, 353},
            {"vie_pro.parcours.formation.3",                                    11, 320, 333},

            {"vie_pro.diplome.1.title",                                         11, 45, 205},
            {"vie_pro.diplome.1.domaine",                                       11, 353, 205},
            {"vie_pro.diplome.2.title",                                         11, 45, 178},
            {"vie_pro.diplome.2.domaine",                                       11, 353, 178},
            {"vie_pro.diplome.3.title",                                         11, 45, 150},
            {"vie_pro.diplome.3.domaine",                                       11, 353, 150},

            {"vie_pro.diplome.bilan.detail",                                    11, 385, 108},

            {"vie_pro.projet_pro",                                              12, 55, 635},
            {"vie_pro.projet_pro.soutien.structure.nom",                        12, 327, 385},
            {"vie_pro.autre",                                                   12, 45, 290},

            {"aidant.situation.nom",                                            13, 170, 645},
            {"aidant.situation.prenom",                                         13, 170, 615},
            {"aidant.situation.lien_psh",                                       13, 275, 580},

            {"aidant.aide_apportee.autre.detail",                               13, 155, 303},
            {"aidant.dedommagement.montant",                                    13, 220, 243},

            {"aidant.remplacement.oui.detail",                                  13, 400, 75},

            {"aidant.futur.autre.detail",                                       14, 156, 613},
            {"aidant.dispositifs.autre.detail",                                 14, 147, 520},

            {"aidant.attentes.autre.detail",                                    14, 152, 298},
            {"aidant.attentes.structure",                                       14, 326, 258},
            {"aidant.attentes.autres_renseignements",                           14, 45, 200},
    };

    private static final Object[][] numberFields = {
            {"dossier.departement",                             0, 238, 60,  5, 11f},

            {"dossier.fin_droit.1.date",                        1, 435, 730, 8, 14f},
            {"dossier.fin_droit.2.date",                        1, 435, 710, 8, 14f},
            {"dossier.fin_droit.3.date",                        1, 435, 690, 8, 14f},

            {"dossier.formation.date",                          1, 335, 613, 8, 14f},

            {"demandeur.date_naissance",                        1, 446, 350, 8, 14f},
            {"demandeur.lieu_naissance.code_postal",            1, 440, 308, 5, 9f},
            {"demandeur.etranger.date_arrivee",                 1, 445, 267, 8, 14f},

            {"demandeur.adresse.code_postal",                   1, 440, 225, 5, 9f},

            {"demandeur.telephone.1",                           1, 167, 180, 10, 9f},
            {"demandeur.telephone.2",                           1, 410, 180, 10, 9f},

            {"demandeur.prestations.num_allocataire",           1, 450, 73, 7, 7f},

            {"demandeur.secu_sociale.sexe",                     1, 167, 50, 2, 8f},
            {"demandeur.secu_sociale.date_naiss",               1, 192, 50, 4, 8f},
            {"demandeur.secu_sociale.dpt_naiss",                1, 235, 50, 2, 8f},
            {"demandeur.secu_sociale.insee_commune",            1, 280, 50, 3, 8f},
            {"demandeur.secu_sociale.insee",                    1, 322, 50, 3, 8f},
            {"demandeur.secu_sociale.cle",                      1, 385, 50, 2, 8f},

            {"parent1.adresse.code_postal",                     2, 175, 620, 5, 7f},
            {"parent1.adresse.telephone",                       2, 175, 580, 10, 6f},

            {"parent2.adresse.code_postal",                     2, 375, 620, 5, 7f},
            {"parent2.adresse.telephone",                       2, 375, 580, 10, 6f},

            {"aide.quotidienne.adresse.code_postal",            2, 175, 331, 5, 7f},
            {"aide.quotidienne.adresse.telephone",              2, 175, 292, 10, 7f},

            {"aide.ponctuelle.adresse.code_postal",             2, 175, 112, 5, 7f},
            {"aide.ponctuelle.adresse.telephone",               2, 175, 72, 10, 7f},

            {"vie_scolaire.situation.etablissement.date",       7, 434, 552, 8, 14f},

            {"vie_pro.situation.emploi.date",                   9, 178, 685, 8, 14f},
            {"vie_pro.situation.sans_emploi.date",              9, 446, 685, 8, 14f},
            {"vie_pro.situation.emploi.volume",                 9, 185, 287, 2, 7f},
            {"vie_pro.situation.arret.date",                    10, 332, 685, 8, 13.5f},
            {"vie_pro.situation.rencontre_carsat.oui",          10, 430, 550, 8, 13.5f},
            {"vie_pro.situation.visite_pre-reprise.oui",        10, 430, 516, 8, 13.5f},

            {"vie_pro.situation.prestation.taux",               10, 500, 243, 2, 7f},
            {"vie_pro.situation.retraite.date",                 10, 226, 143, 8, 13.5f},

            {"vie_pro.parcours.1.debut",                        11, 63, 625, 8, 10f},
            {"vie_pro.parcours.1.fin",                          11, 63, 605, 8, 10f},
            {"vie_pro.parcours.1.volume",                       11, 375, 615, 2, 7f},
            {"vie_pro.parcours.2.debut",                        11, 63, 582, 8, 10f},
            {"vie_pro.parcours.2.fin",                          11, 63, 562, 8, 10f},
            {"vie_pro.parcours.2.volume",                       11, 375, 572, 2, 7f},
            {"vie_pro.parcours.3.debut",                        11, 63, 538, 8, 10f},
            {"vie_pro.parcours.3.fin",                          11, 63, 518, 8, 10f},
            {"vie_pro.parcours.3.volume",                       11, 375, 528, 2, 7f},
            {"vie_pro.parcours.4.debut",                        11, 63, 495, 8, 10f},
            {"vie_pro.parcours.4.fin",                          11, 63, 475, 8, 10f},
            {"vie_pro.parcours.4.volume",                       11, 375, 485, 2, 7f},

            {"vie_pro.diplome.1.date",                          11, 255, 205, 8, 12f},
            {"vie_pro.diplome.2.date",                          11, 255, 178, 8, 12f},
            {"vie_pro.diplome.3.date",                          11, 255, 150, 8, 12f},

            {"aidant.situation.annee_naissance",                13, 500, 645, 4, 7f},
            {"aidant.situation.vit_avec_psh.oui.date",          13, 422, 552, 8, 14f},

            {"demande.date",                                    15, 127, 513, 8, 14f},

    };

    public ImpactFormFiller (){

    }

    @Override
    public Object[][] getCheckboxes() {
        return checkboxes;
    }

    @Override
    public Object[][] getTextFields() {
        return textFields;
    }

    @Override
    public Object[][] getNumberFields() {
        return numberFields;
    }

    @Override
    public void fill() {

    }

    public FormFiller createFormFiller() {
        return null;
    }
}

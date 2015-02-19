package formfiller;

import com.fasterxml.jackson.databind.JsonNode;
import pdfwriter.PdfWriter;
import play.Logger;

public class ImpactFormFiller extends FormFiller {


    private static final Object[][] checkboxes = {
        {"dossier.existant", 0, 40, 60},
        {"dossier.fin_droit", 1, 63, 753},
        {"contexte.urgences.domicile", 1, 63, 661},
        {"contexte.urgences.etablissement", 1, 63, 638},
        {"contexte.urgences.ecole", 1, 63, 615},
        {"contexte.urgences.travail", 1, 322, 661},
        {"contexte.urgences.formation", 1, 322, 638},

        {"demandeur.francais", 1, 167, 330},
        {"demandeur.ue", 1, 258, 330},
        {"demandeur.autre", 1, 382, 330},

        {"demandeur.contact.email", 1, 312, 140},
        {"demandeur.contact.appel", 1, 370, 140},
        {"demandeur.contact.sms", 1, 453, 140},
        {"demandeur.contact.courrier", 1, 500, 140},

        {"demandeur.prestations.CAF", 1, 169, 73},
        {"demandeur.prestations.MSA", 1, 230, 73},
        {"demandeur.prestations.autre", 1, 290, 73},

        {"parent1", 2, 231, 735},
        {"parent2", 2, 438, 735},

        {"aide.quotidienne.proche", 2, 227, 430},
        {"aide.quotidienne.association", 2, 320, 430},
        {"aide.quotidienne.autre", 2, 435, 430},

        {"aide.ponctuelle.tuteur", 2, 260, 230},
        {"aide.ponctuelle.curateur", 2, 328, 230},
        {"aide.pontuelle.autre", 2, 405, 230},

        {"vieQuotidienne.famille.seul", 3, 56, 660},
        {"vieQuotidienne.famille.enfants", 3, 200, 660},
        {"vieQuotidienne.famille.etablissement", 3, 320, 660},
        {"vieQuotidienne.famille.parents", 3, 56, 640},
        {"vieQuotidienne.famille.couple", 3, 200, 640},
        {"vieQuotidienne.famille.autre", 3, 56, 598},

        {"vie_quotidienne.logement.independant", 3, 56, 548},
        {"vie_quotidienne.logement.independant.proprietaire", 3, 136, 530},
        {"vie_quotidienne.logement.independant.locataire", 3, 218, 530},
        {"vie_quotidienne.logement.parents", 3, 320, 548},
        {"vie_quotidienne.logement.enfants", 3, 432, 548},
        {"vie_quotidienne.logement.ami", 3, 320, 525},
        {"vie_quotidienne.logement.famille", 3, 432, 525},
        {"vie_quotidienne.logement.accueil", 3, 320, 503},
        {"vie_quotidienne.logement.autre", 3, 56, 470},

        {"vie_quotidienne.aide_argent", 3, 56, 393},
        {"vie_quotidienne.aide_personne", 3, 56, 342},
        {"vie_quotidienne.aide_personne.famille", 3, 180, 352},
        {"vie_quotidienne.aide_personne.pro", 3, 280, 352},
        {"vie_quotidienne.aide_personne.accompagement", 3, 405, 352},
        {"vie_quotidienne.aide_personne.autre", 3, 180, 332},
        {"vie_quotidienne.aide_materiel", 3, 56, 275},
        {"vie_quotidienne.aide_materiel.logement", 3, 180, 297},
        {"vie_quotidienne.aide_materiel.vehicule", 3, 333, 297},
        {"vie_quotidienne.aide_materiel.animal", 3, 448, 299},
        {"vie_quotidienne.aide_materiel.technique", 3, 180, 275},
        {"vie_quotidienne.aide_materiel.autre", 3, 180, 252},

        {"vieQuotidienne.besoinsVie.courant", 4, 56, 529},
        {"vieQuotidienne.besoinsVie.cuisine", 4, 318, 529},
        {"vieQuotidienne.besoinsVie.budget", 4, 56, 500},
        {"vieQuotidienne.besoinsVie.repas", 4, 318, 500},
        {"vieQuotidienne.besoinsVie.hygiene", 4, 56, 472},
        {"vieQuotidienne.besoinsVie.menage", 4, 318, 472},
        {"vieQuotidienne.besoinsVie.habits", 4, 56, 447},
        {"vieQuotidienne.besoinsVie.sante", 4, 318, 445},
        {"vieQuotidienne.besoinsVie.courses", 4, 56, 422},
        {"vieQuotidienne.besoinsVie.autre", 4, 56, 392},

        {"vieQuotidienne.besoinsDeplacement.intraDomicile", 4, 56, 312},
        {"vieQuotidienne.besoinsDeplacement.conduite", 4, 318, 312},
        {"vieQuotidienne.besoinsDeplacement.accesDomicile", 4, 56, 292},
        {"vieQuotidienne.besoinsDeplacement.transports", 4, 318, 292},
        {"vieQuotidienne.besoinsDeplacement.public", 4, 56, 272},
        {"vieQuotidienne.besoinsDeplacement.vacances", 4, 318, 272},
        {"vieQuotidienne.besoinsTransports.true", 4, 405, 240},
        {"vieQuotidienne.besoinsTransports.false", 4, 460, 240},
        {"vieQuotidienne.besoinsDeplacement.autre", 4, 56, 215},

        {"vieQuotidienne.besoinsSocial.communication", 4, 56, 140},
        {"vieQuotidienne.besoinsSocial.famille", 4, 320, 140},
        {"vieQuotidienne.besoinsSocial.loisirs", 4, 56, 118},
        {"vieQuotidienne.besoinsSocial.citoyen", 4, 320, 118},
        {"vieQuotidienne.besoinsSocial.proches", 4, 56, 95},
        {"vieQuotidienne.besoinsSocial.securite", 4, 320, 95},
        {"vieQuotidienne.besoinsSocial.autre", 4, 56, 60},

        {"vieQuotidienne.attentesTypeAide.domicile", 5, 56, 652},
        {"vieQuotidienne.attentesTypeAide.materiel", 5, 233, 652},
        {"vieQuotidienne.attentesTypeAide.etablissement", 5, 390, 652},
        {"vieQuotidienne.attentesTypeAide.financierMinimum", 5, 56, 622},
        {"vieQuotidienne.attentesTypeAide.amenagement", 5, 233, 622},
        {"vieQuotidienne.attentesTypeAide.financierHandicap", 5, 390, 622},
        {"vieQuotidienne.attentesTypeAide.humain", 5, 56, 590},
        {"vieQuotidienne.attentesTypeAide.mobilite", 5, 233, 590},
        {"vieQuotidienne.attentesTypeAide.autre", 5, 56, 550},

        {"attente.structure_identifiee.oui", 5, 440, 507},
        {"attente.structure_identifiee.non", 5, 495, 507},
        {"attente.structure1.oui", 5, 440, 458},
        {"attente.structure1.non", 5, 495, 458},
        {"attente.structure2.oui", 5, 440, 432},
        {"attente.structure2.non", 5, 495, 432},

        {"vieQuotidienne.attentesCarte.stationnement", 5, 90, 340},
        {"vieQuotidienne.attentesCarte.invalidite", 5, 337, 340},
        {"vieQuotidienne.attentesCarte.aucune", 5, 90, 300},

        {"vie_quotidienne.justificatifs", 6, 55, 312},
        {"vie_quotidienne.reduction_activite_pro", 6, 55, 280},
        {"vie_quotidienne.tierce_personne", 6, 55, 243},
        {"vie_quotidienne.pension_invalidite", 6, 55, 212},

        {"vieScolaire.vieScolaireType.ordinaire", 7, 55, 654},
        {"vieScolaire.vieScolaireType.domicile", 7, 55, 630},
        {"vieScolaire.vieScolaireType.internat", 7, 55, 606},
        {"vieScolaire.vieScolaireType.etablissement", 7, 55, 580},
        {"vieScolaire.vieScolaireType.etablissementPartiel", 7, 55, 554},
        {"vieScolaire.vieScolaireType.superieur", 7, 55, 528},
        {"vieScolaire.vieScolaireType.vieScolaireTypeInternat.true", 7, 423, 497},
        {"vieScolaire.vieScolaireType.vieScolaireTypeInternat.false", 7, 475, 497},
        {"vieScolaire.vieScolaireType.autre", 7, 55, 470},

        {"vieScolaire.raisonNonScolaire.tropJeune", 7, 55, 403},
        {"vieScolaire.raisonNonScolaire.etablissement", 7, 325, 403},
        {"vieScolaire.raisonNonScolaire.autre", 7, 55, 295},

        {"vie_scolaire.GEVAsco", 7, 73, 149},
        {"vie_scolaire.attente.etablissement_identifie.contact.oui", 7, 328, 70},
        {"vie_scolaire.attente.etablissement_identifie.contact.non", 7, 382, 70},

        {"travail.conditionTravail.true", 9, 55, 685},
        {"travail.milieuTravail.adaptee", 9, 55, 640},
        {"travail.milieuTravail.ordinaire", 9, 183, 640},
        {"travail.milieuTravail.etablissement", 9, 55, 620},

        {"travail.typeTravail.cdi", 9, 55, 558},
        {"travail.typeTravail.cdd", 9, 100, 558},
        {"travail.typeTravail.interim", 9, 153, 558},
        {"travail.typeTravail.contrat_aide", 9, 210, 558},
        {"travail.typeTravail.independant", 9, 55, 535},

        {"travail.temps.true", 9, 53, 287},
        {"travail.temps.false", 9, 130, 287},
        {"travail.adapte.true", 9, 195, 246},
        {"travail.adapte.false", 9, 240, 246},
        {"travail.amenagement.true", 9, 53, 123},

        {"travail.conditionTravail.false", 9, 318, 685},

        {"travail.passe.true", 9, 465, 640},
        {"travail.passe.false", 9, 508, 640},

        {"travail.situationSansEmploi.poleEmploi", 9, 318, 427},
        {"travail.situationSansEmploi.formation", 9, 318, 405},
        {"travail.situationSansEmploi.etudiant", 9, 460, 405},
        {"travail.situationSansEmploi.stagiaire", 9, 318, 340},
        {"travail.situationSansEmploi.stagiaireDetail.true", 9, 380, 323},
        {"travail.situationSansEmploi.stagiaireDetail.false", 9, 422, 323},

        {"travail.situationAccompagnement.mission", 9, 318, 203},
        {"travail.situationAccompagnement.poleEmploi", 9, 425, 203},
        {"travail.situationAccompagnement.capEmploi", 9, 318, 175},
        {"travail.situationAccompagnement.rsa", 9, 425, 175},
        {"travail.situationAccompagnement.sameth", 9, 318, 143},
        {"travail.situationAccompagnement.autre", 9, 318, 103},

        {"travail.arretDeTravail.true", 10, 55, 685},
        {"travail.indemniteJournaliere.true", 10, 55, 643},
        {"travail.accidentTravail.true", 10, 308, 643},
        {"travail.indemniteJournaliere.false", 10, 55, 620},
        {"travail.congeMaternite.true", 10, 308, 620},

        {"vie_pro.situation.fiche_medecin", 10, 103, 584},
        {"travail.profesionnelSocial.false", 10, 308, 550},
        {"travail.profesionnelSocial.true", 10, 368, 550},
        {"travail.medecinTravail.false", 10, 308, 516},
        {"travail.medecinTravail.true", 10, 368, 516},

        {"vie_pro.situation.prestation.AAH", 10, 55, 443},
        {"vie_pro.situation.prestation.RSA", 10, 297, 443},
        {"vie_pro.situation.prestation.chomage", 10, 55, 420},
        {"vie_pro.situation.prestation.AGEFIPH", 10, 297, 420},
        {"vie_pro.situation.prestation.ASS", 10, 55, 397},
        {"vie_pro.situation.prestation.FIPHFP", 10, 297, 387},
        {"vie_pro.situation.prestation.retraite", 10, 55, 375},
        {"vie_pro.situation.prestation.invalidite", 10, 55, 344},
        {"vie_pro.situation.prestation.invalidite.1", 10, 198, 344},
        {"vie_pro.situation.prestation.invalidite.2", 10, 278, 344},
        {"vie_pro.situation.prestation.invalidite.autre", 10, 55, 320},
        {"vie_pro.situation.prestation.MTP.oui", 10, 198, 295},
        {"vie_pro.situation.prestation.MTP.non", 10, 245, 295},
        {"vie_pro.situation.prestation.invalidite.justificatif", 10, 102, 267},
        {"vie_pro.situation.prestation.rente", 10, 102, 243},
        {"vie_pro.situation.prestation.RQTH.oui", 10, 444, 211},
        {"vie_pro.situation.prestation.RQTH.non", 10, 496, 211},
        {"vie_pro.situation.prestation.autre", 10, 55, 182},

        {"vie_pro.situation.retraite", 10, 55, 145},
        {"vie_pro.situation.retraite.aspa.oui", 10, 265, 94},
        {"vie_pro.situation.retraite.aspa.non", 10, 305, 94},
        {"vie_pro.situation.retraite.pension.oui", 10, 265, 67},
        {"vie_pro.situation.retraite.pension.non", 10, 305, 67},

        {"vie_pro.parcours.qualification.primaire", 11, 55, 398},
        {"vie_pro.parcours.qualification.secondaire", 11, 120, 398},
        {"vie_pro.parcours.qualification.superieur", 11, 195, 398},

        {"travail.besoinSoutien.bilan", 12, 55, 472},
        {"travail.besoinSoutien.emploi", 12, 320, 472},
        {"travail.besoinSoutien.precisions", 12, 55, 450},
        {"travail.besoinSoutien.formation", 12, 320, 450},
        {"travail.besoinSoutien.environnement", 12, 55, 422},
        {"vie_pro.projet_pro.soutien.structure.contact.oui", 12, 330, 358},
        {"vie_pro.projet_pro.soutien.structure.contact.non", 12, 385, 358},

        {"aidant.vie.false", 13, 275, 550},
        {"aidant.vie.true", 13, 327, 550},

        {"aidant.emploi.true", 13, 275, 528},
        {"aidant.emploi.false", 13, 327, 528},
        {"aidant.emploi.emploiDetail.true", 13, 380, 528},

        {"aidant.natureAide.surveillance", 13, 55, 456},
        {"aidant.natureAide.professionnels", 13, 315, 456},
        {"aidant.natureAide.deplacementInterieur", 13, 55, 436},
        {"aidant.natureAide.juridique", 13, 315, 436},
        {"aidant.natureAide.deplacementExterieur", 13, 55, 416},
        {"aidant.natureAide.finances", 13, 315, 416},
        {"aidant.natureAide.logement", 13, 55, 393},
        {"aidant.natureAide.loisirs", 13, 315, 393},
        {"aidant.natureAide.hygiene", 13, 55, 371},
        {"aidant.natureAide.social", 13, 315, 371},
        {"aidant.natureAide.repasPreparation", 13, 55, 349},
        {"aidant.natureAide.medical", 13, 315, 349},
        {"aidant.natureAide.repasPrise", 13, 55, 329},
        {"aidant.natureAide.autre", 13, 55, 303},

        {"aidant.dedommagement.true", 13, 55, 243},
        {"aidant.dedommagement.false", 13, 315, 243},

        {"aidant.accompagnement.professionnel", 13, 55, 180},
        {"aidant.accompagnement.proches", 13, 193, 180},
        {"aidant.participant.aucun", 13, 380, 180},

        {"aidant.soutien.aucun", 13, 55, 107},
        {"aidant.soutien.rencontres", 13, 193, 107},
        {"aidant.soutien.individuel", 13, 380, 107},

        {"aidant.empechement.true", 13, 315, 75},
        {"aidant.empechement.false", 13, 315, 55},

        {"aidant.situationFuture.eloignement", 14, 56, 700},
        {"aidant.situationFuture.sante", 14, 323, 700},
        {"aidant.situationFuture.indisponible", 14, 56, 678},
        {"aidant.situationFuture.professionnelle", 14, 323, 678},
        {"aidant.situationFuture.personnel", 14, 56, 653},
        {"aidant.situationFuture.autre", 14, 56, 613},

        {"aidant.demandesAides.eloignement", 14, 56, 550},
        {"aidant.demandesAides.indisponible", 14, 140, 550},
        {"aidant.demandesAides.autre", 14, 56, 520},

        {"aidant.typeAttente.repos", 14, 56, 420},
        {"aidant.typeAttente.finance", 14, 310, 420},
        {"aidant.typeAttente.imprevu", 14, 56, 397},
        {"aidant.typeAttente.echanges", 14, 310, 397},
        {"aidant.typeAttente.vacances", 14, 56, 375},
        {"aidant.typeAttente.psychologique", 14, 310, 375},
        {"aidant.typeAttente.professionnel", 14, 56, 353},
        {"aidant.typeAttente.conseil", 14, 310, 353},
        {"aidant.typeAttente.social", 14, 56, 330},
        {"aidant.typeAttente.vieillesse", 14, 310, 330},
        {"aidant.typeAttente.autre", 14, 56, 298},

        {"demande.signature.psh", 15, 126, 488},
        {"demande.signature.representant", 15, 282, 488},
        {"demande.signature.parent", 15, 448, 488},

        {"demande.MDPH_echange_pro.oui", 15, 42, 385},
        {"demande.MDPH_echange_pro.non", 15, 330, 385},
        {"demande.certification_honneur", 15, 42, 307},

    };

    private static final Object[][] textFields = {
        {"dossier.numero", 0, 400, 60},

        {"dossier.fin_droit.1", 1, 120, 730},
        {"dossier.fin_droit.2", 1, 120, 710},
        {"dossier.fin_droit.3", 1, 120, 690},

        {"contexte.urgences.difficulteDetail", 1, 63, 572},

        {"identite.nom", 1, 167, 390},
        {"demandeur.nom_usage", 1, 167, 370},
        {"identite.prenom", 1, 167, 350},
        {"demandeur.lieu_naissance", 1, 167, 310},
        {"demandeur.pays", 1, 167, 290},
        {"demandeur.autre.label", 1, 440, 327},
        {"identite.adresse", 1, 167, 245},
        {"demandeur.adresse.complement", 1, 167, 225},
        {"identite.commune", 1, 167, 205},
        {"identite.pays", 1, 440, 205},
        {"demandeur.email.gauche", 1, 167, 160},
        {"demandeur.email.droite", 1, 365, 160},
        {"demandeur.organisme", 1, 167, 120},

        {"parent1.nom", 2, 175, 700},
        {"parent1.prenom", 2, 175, 677},
        {"parent1.adresse.rue", 2, 175, 658},
        {"parent1.adresse.complement", 2, 175, 638},
        {"parent1.adresse.commune", 2, 175, 600},
        {"parent1.adresse.email", 2, 175, 560},

        {"parent2.nom", 2, 375, 700},
        {"parent2.prenom", 2, 375, 677},
        {"parent2.adresse.rue", 2, 375, 658},
        {"parent2.adresse.complement", 2, 375, 638},
        {"parent2.adresse.commune", 2, 375, 600},
        {"parent2.adresse.email", 2, 375, 560},

        {"aide.quotidienne.adresse.nom", 2, 175, 393},
        {"aide.quotidienne.adresse.rue", 2, 175, 372},
        {"aide.quotidienne.adresse.complement", 2, 175, 351},
        {"aide.quotidienne.adresse.commune", 2, 175, 311},
        {"aide.quotidienne.adresse.email", 2, 175, 272},

        {"aide.ponctuelle.adresse.organisme", 2, 175, 192},
        {"aide.ponctuelle.adresse.nom", 2, 175, 172},
        {"aide.ponctuelle.adresse.rue", 2, 175, 152},
        {"aide.ponctuelle.adresse.complement", 2, 175, 132},
        {"aide.ponctuelle.adresse.commune", 2, 175, 92},
        {"aide.ponctuelle.adresse.email", 2, 175, 52},

        {"vieQuotidienne.famille.logement_etablissement", 3, 320, 640},
        {"vieQuotidienne.famille.famille_autre", 3, 200, 598},

        {"vie_quotidienne.logement.autre.detail", 3, 200, 472},

        {"vie_quotidienne.aide_argent.revenu", 3, 370, 402},
        {"vie_quotidienne.aide_argent.depenses", 3, 370, 383},
        {"vie_quotidienne.aide_personne.autre", 3, 245, 332},
        {"vie_quotidienne.aide_materiel.technique.detail", 3, 333, 275},
        {"vie_quotidienne.aide_materiel.autre.detail", 3, 245, 252},

        {"vie_quotidienne.frais1", 3, 10, 120},
        {"vie_quotidienne.frais1.frequence", 3, 185, 120},
        {"vie_quotidienne.frais1.total", 3, 260, 120},
        {"vie_quotidienne.frais1.rembourse", 3, 333, 120},
        {"vie_quotidienne.frais1.detail", 3, 410, 120},

        {"vie_quotidienne.frais2", 3, 10, 100},
        {"vie_quotidienne.frais2.frequence", 3, 185, 100},
        {"vie_quotidienne.frais2.total", 3, 260, 100},
        {"vie_quotidienne.frais2.rembourse", 3, 333, 100},
        {"vie_quotidienne.frais2.detail", 3, 410, 100},

        {"vie_quotidienne.frais3", 3, 10, 80},
        {"vie_quotidienne.frais3.frequence", 3, 185, 80},
        {"vie_quotidienne.frais3.total", 3, 260, 80},
        {"vie_quotidienne.frais3.rembourse", 3, 333, 80},
        {"vie_quotidienne.frais3.detail", 3, 410, 80},

        {"vie_quotidienne.frais4", 3, 10, 60},
        {"vie_quotidienne.frais4.frequence", 3, 185, 60},
        {"vie_quotidienne.frais4.total", 3, 260, 60},
        {"vie_quotidienne.frais4.rembourse", 3, 333, 60},
        {"vie_quotidienne.frais4.detail", 3, 410, 60},

        {"vieQuotidienne.besoinsVie.besoinsVie_autre", 4, 190, 392},

        {"vieQuotidienne.besoinsDeplacement.besoinsDeplacement_autre", 4, 190, 215},

        {"vieQuotidienne.besoinsSocial.besoinsSocial_autre", 4, 190, 60},

        {"vieQuotidienne.attentesTypeAide.attentesTypeAide_autre", 5, 190, 550},
        {"attente.structure1", 5, 130, 455},
        {"attente.structure2", 5, 130, 435},

        {"vieQuotidienne.autresRenseignements", 6, 50, 715},

        {"vie_scolaire.situation.etablissement.liste", 7, 323, 630},
        {"vieScolaire.vieScolaireType.vieScolaireAutre", 7, 150, 470},

        {"vieScolaire.raisonNonScolaire.raisonNonScolaireTropJeune", 7, 55, 370},
        {"vieScolaire.raisonNonScolaire.raisonNonScolaireEtablissement", 7, 325, 370},
        {"vieScolaire.raisonNonScolaire.raisonNonScolaireAutre", 7, 150, 300},

        {"vie_scolaire.attente.etablissement_identifie", 7, 326, 115},
        {"vieScolaire.vieScolaireAutresRenseignements", 8, 50, 695},

        {"travail.typeTravail.independantDetail", 9, 150, 535},

        {"travail.employeur.nom.value", 9, 120, 468},
        {"travail.employeur.adresse.value", 9, 120, 447},
        {"travail.employeur.medecin.value", 9, 55, 390},
        {"travail.nomPoste", 9, 120, 318},
        {"travail.adapte.adapteDetail", 9, 121, 230},

        {"travail.difficultes", 9, 55, 195},
        {"travail.amenagement.amenagementDetail", 9, 55, 105},

        {"travail.passe.passeDetail", 9, 318, 575},
        {"vie_pro.situation.sans_emploi.detail", 9, 370, 385},
        {"travail.situationStage", 9, 391, 293},
        {"travail.situationAccompagnement.autreDetail", 9, 318, 87},

        {"vie_pro.situation.prestation.invalidite.autre.detail", 10, 248, 320},
        {"vie_pro.situation.prestation.autre.detail", 10, 150, 182},

        {"vie_pro.parcours.1.poste", 11, 143, 615},
        {"vie_pro.parcours.1.entreprise", 11, 245, 615},
        {"vie_pro.parcours.1.motif", 11, 420, 615},
        {"vie_pro.parcours.2.poste", 11, 143, 572},
        {"vie_pro.parcours.2.entreprise", 11, 245, 572},
        {"vie_pro.parcours.2.motif", 11, 420, 572},
        {"vie_pro.parcours.3.poste", 11, 143, 528},
        {"vie_pro.parcours.3.entreprise", 11, 245, 528},
        {"vie_pro.parcours.3.motif", 11, 420, 528},
        {"vie_pro.parcours.4.poste", 11, 143, 485},
        {"vie_pro.parcours.4.entreprise", 11, 245, 485},
        {"vie_pro.parcours.4.motif", 11, 420, 485},

        {"vie_pro.parcours.qualification.classe", 11, 183, 363},

        {"vie_pro.parcours.formation.1", 11, 320, 373},
        {"vie_pro.parcours.formation.2", 11, 320, 353},
        {"vie_pro.parcours.formation.3", 11, 320, 333},

        {"vie_pro.diplome.1.title", 11, 45, 205},
        {"vie_pro.diplome.1.domaine", 11, 353, 205},
        {"vie_pro.diplome.2.title", 11, 45, 178},
        {"vie_pro.diplome.2.domaine", 11, 353, 178},
        {"vie_pro.diplome.3.title", 11, 45, 150},
        {"vie_pro.diplome.3.domaine", 11, 353, 150},

        {"vie_pro.diplome.bilan.detail", 11, 385, 108},

        {"travail.description.descriptionDetail", 12, 55, 635},
        {"vie_pro.projet_pro.soutien.structure.nom", 12, 327, 385},
        {"travail.autresRenseignements", 12, 45, 290},

        {"aidant.situation.nom", 13, 170, 645},
        {"aidant.situation.prenom", 13, 170, 615},
        {"aidant.lien", 13, 275, 580},

        {"aidant.natureAide.natureAideDetail", 13, 155, 303},
        {"aidant.dedommagement.dedommagementDetail", 13, 220, 243},

        {"aidant.empechement.empechementDetail", 13, 400, 75},

        {"aidant.situationFuture.situationDetail", 14, 156, 613},
        {"aidant.demandesAides.aidesDetail", 14, 147, 520},

        {"aidant.typeAttente.attentesDetail", 14, 152, 298},
        {"aidant.attentes.structure", 14, 326, 258},
        {"aidant.autresRenseignements", 14, 45, 200},
    };

    private static final Object[][] numberFields = {
        {"dossier.departement", 0, 238, 60, 5, 11f},

        {"dossier.fin_droit.1.date", 1, 435, 730, 8, 14f},
        {"dossier.fin_droit.2.date", 1, 435, 710, 8, 14f},
        {"dossier.fin_droit.3.date", 1, 435, 690, 8, 14f},

        {"dossier.formation.date", 1, 335, 613, 8, 14f},

        {"identite.birthDate", 1, 446, 350, 8, 14f},
        {"demandeur.lieu_naissance.code_postal", 1, 440, 308, 5, 9f},
        {"demandeur.etranger.date_arrivee", 1, 445, 267, 8, 14f},

        {"identite.code_postal", 1, 440, 225, 5, 9f},

        {"demandeur.telephone.1", 1, 167, 180, 10, 9f},
        {"demandeur.telephone.2", 1, 410, 180, 10, 9f},

        {"demandeur.prestations.num_allocataire", 1, 450, 73, 7, 7f},

        {"demandeur.secu_sociale.sexe", 1, 167, 50, 2, 8f},
        {"demandeur.secu_sociale.date_naiss", 1, 192, 50, 4, 8f},
        {"demandeur.secu_sociale.dpt_naiss", 1, 235, 50, 2, 8f},
        {"demandeur.secu_sociale.insee_commune", 1, 280, 50, 3, 8f},
        {"demandeur.secu_sociale.insee", 1, 322, 50, 3, 8f},
        {"demandeur.secu_sociale.cle", 1, 385, 50, 2, 8f},

        {"parent1.adresse.code_postal", 2, 175, 620, 5, 7f},
        {"parent1.adresse.telephone", 2, 175, 580, 10, 6f},

        {"parent2.adresse.code_postal", 2, 375, 620, 5, 7f},
        {"parent2.adresse.telephone", 2, 375, 580, 10, 6f},

        {"aide.quotidienne.adresse.code_postal", 2, 175, 331, 5, 7f},
        {"aide.quotidienne.adresse.telephone", 2, 175, 292, 10, 7f},

        {"aide.ponctuelle.adresse.code_postal", 2, 175, 112, 5, 7f},
        {"aide.ponctuelle.adresse.telephone", 2, 175, 72, 10, 7f},

        {"vie_scolaire.situation.etablissement.date", 7, 434, 552, 8, 14f},

        {"vie_pro.situation.emploi.date", 9, 178, 685, 8, 14f},
        {"vie_pro.situation.sans_emploi.date", 9, 446, 685, 8, 14f},
        {"travail.heures", 9, 185, 287, 2, 7f},

        {"travail.arretDeTravail.arretDeTravailDetail", 10, 332, 685, 8, 13.5f},

        {"travail.profesionnelSocial.profesionnelSocialDetail", 10, 430, 550, 8, 13.5f},
        {"travail.medecinTravail.medecinTravailDetail", 10, 430, 516, 8, 13.5f},

        {"vie_pro.situation.prestation.taux", 10, 500, 243, 2, 7f},
        {"vie_pro.situation.retraite.date", 10, 226, 143, 8, 13.5f},

        {"vie_pro.parcours.1.debut", 11, 63, 625, 8, 10f},
        {"vie_pro.parcours.1.fin", 11, 63, 605, 8, 10f},
        {"vie_pro.parcours.1.volume", 11, 375, 615, 2, 7f},
        {"vie_pro.parcours.2.debut", 11, 63, 582, 8, 10f},
        {"vie_pro.parcours.2.fin", 11, 63, 562, 8, 10f},
        {"vie_pro.parcours.2.volume", 11, 375, 572, 2, 7f},
        {"vie_pro.parcours.3.debut", 11, 63, 538, 8, 10f},
        {"vie_pro.parcours.3.fin", 11, 63, 518, 8, 10f},
        {"vie_pro.parcours.3.volume", 11, 375, 528, 2, 7f},
        {"vie_pro.parcours.4.debut", 11, 63, 495, 8, 10f},
        {"vie_pro.parcours.4.fin", 11, 63, 475, 8, 10f},
        {"vie_pro.parcours.4.volume", 11, 375, 485, 2, 7f},

        {"vie_pro.diplome.1.date", 11, 255, 205, 8, 12f},
        {"vie_pro.diplome.2.date", 11, 255, 178, 8, 12f},
        {"vie_pro.diplome.3.date", 11, 255, 150, 8, 12f},

        {"aidant.situation.annee_naissance", 13, 500, 645, 4, 7f},
        {"aidant.vie.vieDetail", 13, 422, 552, 8, 14f},

        {"demande.date", 15, 127, 513, 8, 14f},

    };

    public ImpactFormFiller() {

    }

    @Override
    public void fill() {

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

    public void writeCheckbox(Object[] checkbox) {
        int page = (int) checkbox[1];
        float x = checkbox[2] instanceof Float ? (float) checkbox[2] : ((Integer) checkbox[2]).floatValue();
        float y = checkbox[3] instanceof Float ? (float) checkbox[3] : ((Integer) checkbox[3]).floatValue();
        writer.setPage(page);
        writer.checkbox(x + 2, y + 2);

        return;
    }

    public void fillJson(JsonNode json) {
        // Cas spécial identité
        JsonNode nodeIdentite = json.findValue("identite.sexe");
        if (nodeIdentite != null) {
            if (nodeIdentite.textValue().equals("masculin")) {
                Object[] masc = {"identite.sexe.masculin", 1, 167, 410};
                writeCheckbox(masc);
            } else {
                Object[] fem = {"identite.sexe.feminin", 1, 255, 410};
                writeCheckbox(fem);
            }
        }

        //Cas spécial email
        nodeIdentite = json.findValue("identite.email");
        if (nodeIdentite != null) {
            String[] values = nodeIdentite.asText().split("@", 2);
            appendText("demandeur.email.gauche", values[0]);
            appendText("demandeur.email.droite", values[1]);
        }

        for (Object[] checkbox : checkboxes) {
            String checkboxIndex = checkbox[0].toString();
            JsonNode jsonValue = json.findValue(checkboxIndex);
            if (null == jsonValue) {
                continue;
            }
            writeCheckbox(checkbox);

            String value = jsonValue.textValue();
            Logger.info("Checkbox : " + value);
        }
        for (Object[] textfield : textFields) {

            String textFieldIndex = textfield[0].toString();
            JsonNode jsonValue = json.findValue(textFieldIndex);
            if (null == jsonValue) {
                continue;
            }
            appendText(textFieldIndex, jsonValue.asText());
            Logger.info("TextField : " + jsonValue.asText());
        }

        for (Object[] numberfield : numberFields) {

            String numberFieldIndex = numberfield[0].toString();
            JsonNode jsonValue = json.findValue(numberFieldIndex);
            if (null == jsonValue) {
                continue;
            }
            appendNumber(numberFieldIndex, jsonValue.asText());
            Logger.info("NumberField : " + jsonValue.asText());
        }
    }

}

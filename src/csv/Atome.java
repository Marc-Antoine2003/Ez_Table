package csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atome {

    private int numeroAtomique;
    private String nom;
    private ArrayList<Integer> couchesElectrons = new ArrayList<>();
    private String abreviation;
    private int famille;
    private int periode;
    private char block;
    private double masse;
    private String rayonAtomique;
    private String rayonVander;
    private String configElectroniqueText;
    private List<String> oxydations = new ArrayList<>();
    private double electronegativite;
    private double fusion;
    private double ebullition;
    private boolean radioactivite;
    private ArrayList<String> tabConfigElectronique= new ArrayList<>();




    public Atome(String numeroAtomique, String nom, String couchesElectrons, String abreviation, String famille, String periode, String block, String masse, String rayonAtomique, String rayonVander, String configElectronique, String oxydation, String electronegativite, String fusion, String ebullition, String  radioactivite) {

        setNumeroAtomique(numeroAtomique);
        setNom(nom);
        setCouchesElectrons(couchesElectrons);
        setAbreviation(abreviation);
        setFamille(famille);
        setPeriode(periode);
        setBlock(block);
        setMasse(masse);
        setRayonAtomique(rayonAtomique);
        setRayonVander(rayonVander);
        setConfigElectroniqueText(configElectronique);
        setOxydations(oxydation);
        setElectronegativite(electronegativite);
        setFusion(fusion);
        setEbullition(ebullition);
        setRadioactivite(radioactivite);
        setTabConfigElectronique(configElectronique);

    }

    public int getNumeroAtomique() {
        return numeroAtomique;
    }

    public void setNumeroAtomique(String numeroAtomique) {
        this.numeroAtomique = Integer.parseInt(numeroAtomique);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Integer> getCouchesElectrons() {
        return couchesElectrons;
    }

    public void setCouchesElectrons(String couchesElectrons) {
        if(!couchesElectrons.isEmpty()) {
            String[] couches = couchesElectrons.split("-");

            for (int i = 0; i < couches.length; i++) {
                this.couchesElectrons.add(Integer.parseInt(couches[i]));
            }
        }

    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public int getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        if(!famille.isEmpty())
        this.famille = Integer.parseInt(famille);
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        if(!periode.isEmpty())
        this.periode = Integer.parseInt(periode);
    }

    public char getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block.charAt(0);
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(String masse) {
        this.masse = Double.parseDouble(masse.trim());
    }

    public String getRayonAtomique() {
        return rayonAtomique;
    }

    public void setRayonAtomique(String rayonAtomique) {
        if(!rayonAtomique.isEmpty())
        this.rayonAtomique = rayonAtomique;
    }

    public String getRayonVander() {
        return rayonVander;
    }

    public void setRayonVander(String rayonVander) {
        if(!rayonVander.isEmpty())
        this.rayonVander = rayonVander;
    }

    public String getConfigElectroniqueText() {
        return configElectroniqueText;
    }

    public void setConfigElectroniqueText(String configElectronique) {
        if(!configElectronique.isEmpty())
        this.configElectroniqueText = configElectronique;
    }

    public List<String> getOxydations() {
        return oxydations;
    }

    public void setOxydations(String oxydations) {
        if(!oxydations.isEmpty()) {
            String[] nivOxy = oxydations.split(". ");

            for (int i = 0; i < nivOxy.length; i++) {
                if (!nivOxy[i].contains("-") && !nivOxy[i].contains("+") && !nivOxy[i].equals("0"))
                    nivOxy[i] = "+" + nivOxy[i];
            }

            this.oxydations = Arrays.asList(nivOxy);
        }
    }

    public double getElectronegativite() {
        return electronegativite;
    }

    public void setElectronegativite(String electronegativite) {
        if(!electronegativite.isEmpty())
        this.electronegativite = Double.parseDouble(electronegativite);
    }

    public double getFusion() {
        return fusion;
    }

    public void setFusion(String fusion) {
        if(!fusion.isEmpty())
        this.fusion = Double.parseDouble(fusion);
    }

    public double getEbullition() {
        return ebullition;
    }

    public void setEbullition(String ebullition) {
        if(!ebullition.isEmpty())
        this.ebullition = Double.parseDouble(ebullition);
    }

    public String isRadioactivite() {
        String retour;

        if (radioactivite)
            retour = "Oui";
        else
            retour = "Non";

        return retour;
    }
    public void setRadioactivite(String radioactivite) {
            if ( Integer.parseInt(radioactivite) == 1)
            {
                this.radioactivite = true;
            }
            else
            {
                this.radioactivite = false;
            }
    }

    public void setTabConfigElectronique(String tabConfigElectronique) {
        String s = tabConfigElectronique.substring(0, 2);
        String complet = tabConfigElectronique;
        String[] tableau;

        switch (s) {
            case "He":
                complet = tabConfigElectronique.replace("He", "1s2");
                break;
            case "Ne":
                complet = tabConfigElectronique.replace("Ne", "1s2 2s2 2p6");
                break;
            case "Ar":
                complet = tabConfigElectronique.replace("Ar", "1s2 2s2 2p6 3s2 3p6");
                break;
            case "Kr":
                complet = tabConfigElectronique.replace("Kr", "1s2 2s2 2p6 3s2 3p6 3d10 4s2 4p6");
                break;
            case "Xe":
                complet = tabConfigElectronique.replace("Xe", "1s2 2s2 2p6 3s2 3p6 3d10 4s2 4p6 4d10 5s2 5p6");
                break;
            case "Rn":
                complet = tabConfigElectronique.replace("Rn", "1s2 2s2 2p6 3s2 3p6 3d10 4s2 4p6 4d10 5s2 5p6 4f14 5d10 6s2 6p6");
                break;
        }

        tableau = complet.split(" ");

        for (int i = 0; i < tableau.length; i++) {
            int couche = Integer.parseInt(tableau[i].substring(0, 1));
            int nbElectrons = Integer.parseInt(tableau[i].substring(2, 3));
            if (tableau[i].contains("s")) {

                this.tabConfigElectronique.add(couche + "s");
            } else if (tableau[i].contains("p")) {
                if (nbElectrons == 1) {
                    this.tabConfigElectronique.add(couche + "p1");
                } else if (nbElectrons == 2) {
                    this.tabConfigElectronique.add(couche + "p1");
                    this.tabConfigElectronique.add(couche + "p2");
                } else {
                    this.tabConfigElectronique.add(couche + "p1");
                    this.tabConfigElectronique.add(couche + "p2");
                    this.tabConfigElectronique.add(couche + "p3");
                }
            } else if (tableau[i].contains("d")) {
                if (nbElectrons == 1) {
                    this.tabConfigElectronique.add(couche + "d1");
                } else if (nbElectrons == 2) {
                    this.tabConfigElectronique.add(couche + "d1");
                    this.tabConfigElectronique.add(couche + "d2");
                } else if (nbElectrons == 3) {
                    this.tabConfigElectronique.add(couche + "d1");
                    this.tabConfigElectronique.add(couche + "d2");
                    this.tabConfigElectronique.add(couche + "d3");
                } else if (nbElectrons == 4) {
                    this.tabConfigElectronique.add(couche + "d1");
                    this.tabConfigElectronique.add(couche + "d2");
                    this.tabConfigElectronique.add(couche + "d3");
                    this.tabConfigElectronique.add(couche + "d4");

                } else {
                    this.tabConfigElectronique.add(couche + "d1");
                    this.tabConfigElectronique.add(couche + "d2");
                    this.tabConfigElectronique.add(couche + "d3");
                    this.tabConfigElectronique.add(couche + "d4");
                    this.tabConfigElectronique.add(couche + "d5");

                }

            } else if (tableau[i].contains("f")) {
                if (nbElectrons == 1) {
                    this.tabConfigElectronique.add(couche + "f1");
                } else if (nbElectrons == 2) {
                    this.tabConfigElectronique.add(couche + "f1");
                    this.tabConfigElectronique.add(couche + "f2");
                } else if (nbElectrons == 3) {
                    this.tabConfigElectronique.add(couche + "f1");
                    this.tabConfigElectronique.add(couche + "f2");
                    this.tabConfigElectronique.add(couche + "f3");
                } else if (nbElectrons == 4) {
                    this.tabConfigElectronique.add(couche + "f1");
                    this.tabConfigElectronique.add(couche + "f2");
                    this.tabConfigElectronique.add(couche + "f3");
                    this.tabConfigElectronique.add(couche + "f4");

                } else if (nbElectrons == 5) {
                    this.tabConfigElectronique.add(couche + "f1");
                    this.tabConfigElectronique.add(couche + "f2");
                    this.tabConfigElectronique.add(couche + "f3");
                    this.tabConfigElectronique.add(couche + "f4");
                    this.tabConfigElectronique.add(couche + "f5");

                } else if (nbElectrons == 6) {
                    this.tabConfigElectronique.add(couche + "f1");
                    this.tabConfigElectronique.add(couche + "f2");
                    this.tabConfigElectronique.add(couche + "f3");
                    this.tabConfigElectronique.add(couche + "f4");
                    this.tabConfigElectronique.add(couche + "f5");
                    this.tabConfigElectronique.add(couche + "f6");

                }
                else
                {
                    this.tabConfigElectronique.add(couche + "f1");
                    this.tabConfigElectronique.add(couche + "f2");
                    this.tabConfigElectronique.add(couche + "f3");
                    this.tabConfigElectronique.add(couche + "f4");
                    this.tabConfigElectronique.add(couche + "f5");
                    this.tabConfigElectronique.add(couche + "f6");
                    this.tabConfigElectronique.add(couche + "f7");
                }
            }
        }

        for(int i = 0; i < this.tabConfigElectronique.size(); i++)
        {
            System.out.print(this.tabConfigElectronique.get(i));
        }
        System.out.println("");
    }

    @Override
    public String toString()
    {
        return getNumeroAtomique() +" " + getNom()+ ": "+ getAbreviation() + " " + configElectroniqueText;
    }
}

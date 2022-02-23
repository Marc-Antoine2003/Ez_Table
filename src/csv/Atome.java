package csv;

import java.util.ArrayList;

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
    private ArrayList<Integer> oxydations = new ArrayList<Integer>();
    private double electronegativite;
    private double fusion;
    private double ebullition;
    private boolean radioactivite;


    public Atome(String numeroAtomique, String nom, String couchesElectrons, String abreviation, String famille, String periode, String block, String masse,  String rayonAtomique, String rayonVander, String configElectronique, String oxydation, String electronegativite, String fusion, String ebullition, String  radioactivite) {

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

    public ArrayList<Integer> getOxydations() {
        return oxydations;
    }

    public void setOxydations(String oxydations) {
        if(!oxydations.isEmpty()) {
            String[] nivOxy = oxydations.split(". ");


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

    public boolean isRadioactivite() {
        return radioactivite;
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

    @Override
    public String toString()
    {

        return getNumeroAtomique() +" " + getNom()+ ": "+ getAbreviation() + " " + configElectroniqueText;
    }
}

package formfiller;

public class ImpactFormFiller extends FormFiller{

    private static final Object[][] checkboxes = {
            {"dossier.existant", 0, 40, 60}
    };

    private static final Object[][] textFields = {
            {"dossier.numero", 0, 400, 60}
    };

    private static final Object[][] numberFields = {
            {"dossier.departement", 0, 238, 60,  5, 11f}
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

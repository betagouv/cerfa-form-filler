package controllers;

import actions.AddAccessControlHeadersAction;
import formfiller.FormFiller;
import formfiller.ImpactFormFiller;
import org.apache.pdfbox.pdmodel.PDDocument;
import pdfwriter.PdfWriter;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.io.File;
import java.io.IOException;

@With(AddAccessControlHeadersAction.class)
public class ImpactController extends Controller {

    public static Result generateFake() throws IOException {

        FormFiller filler = createFormFiller();
        filler.fillFake();

        File file = File.createTempFile("tmp", ".pdf");
        try {
            filler.getWriter().save(file);
            return ok(file, "impact.pdf");
        } finally {
            file.delete();
        }
    }

    private static FormFiller createFormFiller() throws IOException {
        ImpactFormFiller filler = new ImpactFormFiller();
        PDDocument document = PDDocument.load(String.format("resources/impact.pdf"));
        filler.setWriter(new PdfWriter(document));

        return filler;
    }

}

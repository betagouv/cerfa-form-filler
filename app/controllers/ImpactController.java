package controllers;

import actions.AddAccessControlHeadersAction;
import com.fasterxml.jackson.databind.JsonNode;
import formfiller.FormFiller;
import formfiller.ImpactFormFiller;
import org.apache.pdfbox.pdmodel.PDDocument;
import pdfwriter.PdfWriter;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.io.File;
import java.io.IOException;

@With(AddAccessControlHeadersAction.class)
public class ImpactController extends Controller {


    @BodyParser.Of(BodyParser.Json.class)
    public static Result generate() throws IOException {

        JsonNode json = request().body().asJson();
        ImpactFormFiller filler = createFormFiller();
        filler.fillJson(json);

        File file = File.createTempFile("tmp", ".pdf");
        try {
            filler.getWriter().save(file);
            return ok(file, "impact.pdf");
        } finally {
            file.delete();
        }
    }

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

    private static ImpactFormFiller createFormFiller() throws IOException {
        ImpactFormFiller filler = new ImpactFormFiller();
        PDDocument document = PDDocument.load(String.format("resources/impact.pdf"));
        filler.setWriter(new PdfWriter(document));

        return filler;
    }
}

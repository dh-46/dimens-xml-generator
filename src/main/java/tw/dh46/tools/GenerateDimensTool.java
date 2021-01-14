package tw.dh46.tools;

import java.io.*;

public class GenerateDimensTool {

    public static final String VALUES_MDPI = "values-mdpi";
    public static final String VALUES_HDPI = "values-hdpi";
    public static final String VALUES_XHDPI = "values-xhdpi";
    public static final String VALUES_XXHDPI = "values-xxhdpi";
    public static final String VALUES_XXXHDPI = "values-xxxhdpi";

    public static void main(String[] args) {
        // createDimens(1.33f, VALUES_XXXHDPI,"");
//        createDimens(1.6f, "values-sw720dp","");
//         createDimens(0.5f, VALUES_HDPI,"");
//         createDimens(0.33f, VALUES_MDPI,"");
    }

    /**
     *
     * @param scaleRatio
     * @param folderName values-sw600dp, values-hdpi...etc.
     * @param projectPath
     */
    public static void createDimens(float scaleRatio, String folderName, String projectPath) {
        StringBuilder lines = new StringBuilder();
        //Add the tag at the beginning of xml
        String xmlStart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<resources>\n";
        lines.append(xmlStart);
        //Add content
        for (int i = 0; i <= 1920; i++) {
            // The label name after name can be customized "margin_" to change at will
            float value = i * scaleRatio;
            String start = "<dimen name=\"dp_" + i + "\">";
            String end = "dp</dimen>";
            lines.append(start).append(value).append(end).append("\n");
        }

        for (int i = 0; i <= 180; i++) {
            // The label name after name can be customized "margin_" to change at will
            float value = i * scaleRatio;
            String start = "<dimen name=\"sp_" + i + "\">";
            String end =  "sp</dimen>";
            lines.append(start).append(value).append(end).append("\n");
        }

        //Add the xml tail tag
        lines.append("</resources>");

//        String folderPath = "./app/src/main/res/" + folderName;
        String folderPath =projectPath + folderName;
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filePath = folderPath + "/dimens.xml";
        writeFile(filePath, lines.toString());
    }

    public static void writeFile(String file, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();
    }
}

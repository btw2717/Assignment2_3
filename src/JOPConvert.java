//importing all the requisite packages to make the necessary classes available to the application
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Optional;

/**
 * The JOPConvert class uses various JavaFX dialogs and Swing dialogs
 * to prompt the user for their height in centimeters,
 * convert that value to feet and inches,
 * and output the results in dialog boxes as well.
 * This class has swing components embedded....??(I don't really know what that means, so probably not.  but maybe.)
 *
 * The Alert dialog class and methods are imported from the javafx package.
 * The JOptionPane and JDialog classes are imported from the swing package.
 *
 * The JOPConvert class extends the Application class and so makes available the methods of the
 * Application class.
 * The Application class is the entry point for JavaFX applications.
 *
 * This class contains two methods, main() and start().  As a JavaFX application, this class
 * begins execution at the start() method.
 *
 * email: btannerw@gmail.com
 * Created 16SEP2017
 * @author Sapper
 * @version 1.0
 */

public class JOPConvert extends Application {
    /**
     * The main() method is not used and is ignored in this class because
     * it is a JavaFX application.
     * main()is included along with a call to launch as a fallback, which will end up launching
     * the JavaFX program and the start method.
     *
     * @param args arguments passed through the command line.
     */

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start() method is the begin execution point for the application.
     * The main entry point for all JavaFX applications.
     * The start() method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * start() is public, so it can interact with any part of this or another application.
     * start() is a void method, and so performs some action other than to return an item.
     * The start() method is abstract and must be overridden.
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded
     *                     in the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not
     *                     be primary stages and will not be embedded in the browser.
     * @throws Exception indicates conditions that a reasonable application might want to catch.
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Introductory Alert dialog to introduce the user to the application.
        Alert intro = new Alert(Alert.AlertType.INFORMATION);
        intro.setTitle("Introduction");
        intro.setHeaderText("Hello!");
        intro.setContentText("I am a unit converter,\nI like to convert centimeter values" +
                " to feet and inches.\n" +
                "Because this is America!\n" +
                "All you have to do to feed me is follow the instructions on the subsequent dialog boxes.\n" +
                "Press enter to begin!");
        intro.showAndWait();

        //Format the visible output of the double values that will be displayed later
        DecimalFormat decFormat = new DecimalFormat("#.#");

        //The swing version of the input dialog box
        JOptionPane input = new JOptionPane("Please enter your height in centimeters:");
        input.setWantsInput(true);
        JDialog inputWindow;
        inputWindow = input.createDialog("Centimeters to Feet and Inches");
        inputWindow.setLocation(0, 400);
        inputWindow.setAlwaysOnTop(true);
        inputWindow.setVisible(true);
        //converting centimeters to feet and inches
        double inputCM = Double.parseDouble((String) (input.getInputValue()));
        double heightInCm = inputCM;
        double heightInIn = heightInCm / 2.54;
        double heightInFt = heightInIn / 12;
        double decimalFt = heightInFt - (int)heightInFt;
        double inches = decimalFt * 12;



        //The javafx version of the input dialog box
        TextInputDialog inputFX = new TextInputDialog();
        inputFX.setX(400);
        inputFX.setY(0);
        inputFX.setTitle("FX Input");
        inputFX.setHeaderText("Centimeters to Feet and Inches");
        inputFX.setContentText("Please enter your height in centimeters:");
        Optional<String> resultFX = inputFX.showAndWait();
        //converting centimeters to feet and inches
        double heightInCmFX = Double.parseDouble(resultFX.get());
        double heightInInFX = heightInCmFX / 2.54;
        double heightInFtFX = heightInInFX / 12;
        double decimalFtFX = heightInFtFX - (int)heightInFtFX;
        double inchesFX = decimalFtFX * 12;


        //The swing version of the output dialog box
        JOptionPane output = new JOptionPane("Your height:\nIn Feet: " + (int)heightInFt +
                "\'\nIn Inches: " + decFormat.format(inches) + "\"");
        JDialog outputWindow = output.createDialog("Your Height");
        outputWindow.setLocation(1000, 400);
        outputWindow.setAlwaysOnTop(true);
        outputWindow.setVisible(true);

        //The javafx version of the output dialog box
        Alert outputFX = new Alert(Alert.AlertType.INFORMATION);
        outputFX.setX(400);
        outputFX.setY(700);
        outputFX.setTitle("FX Output");
        outputFX.setHeaderText("Height in Feet and Inches");
        outputFX.setContentText("Your Height:\nIn Feet: " + (int)heightInFtFX +
                "\'\nIn Inches: " + decFormat.format(inchesFX) + "\"");
        outputFX.showAndWait();


        System.exit(0);
    }
}
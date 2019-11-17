package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.io.*;
import javax.imageio.ImageIO;

import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.scene.image.WritableImage;
import java.awt.image.RenderedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private final static int CANVAS_WIDTH = 1100;
    private final static int CANVAS_HEIGHT = 570;

    private final PaintTools.BrushTool brushTool = new PaintTools.BrushTool();
    private final PaintTools.RectangleTool rectangleTool = new PaintTools.RectangleTool();
    private final PaintTools.EllipseTool ellipseTool = new PaintTools.EllipseTool();

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker brushColorPicker;
    @FXML
    private ColorPicker rectangleColorPicker;
    @FXML
    private ColorPicker ellipseColorPicker;

    @FXML
    private Slider sizeSlider;

    @FXML
    private CheckBox rectangleFilled;
    @FXML
    private CheckBox ellipseFilled;

    CheckBox isFilled;
    GraphicsContext GCTool;

    // start with brush
    private PaintTool selectedTool = brushTool;
    private ColorPicker colorPicker = brushColorPicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GCTool = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(event -> selectedTool.onMousePressed(event, this));

        canvas.setOnMouseDragged(event -> selectedTool.onMouseDragged(event, this));

        canvas.setOnMouseReleased(event -> selectedTool.onMouseReleased(event, this));


        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            sizeSlider.setValue(newValue.intValue());
            GCTool.setLineWidth(sizeSlider.getValue()/10);
        });
    }

    /**
     * Callback upon clear button click
     *
     * Clear the canvas
     */
    public void onClearButtonClicked(){
        GCTool.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    /**
     * Callback upon save button click
     *
     * Initiate save painting as .jpg file
     */
    public void onSaveButtonClicked(){
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(Main.window);

        if(file != null){
            try {
                WritableImage writableImage = new WritableImage(CANVAS_WIDTH, CANVAS_HEIGHT);
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                System.out.printf("Error %s occurred", ex);
            }
        }
    }

    /**
     * Callback upon open button click
     *
     * Initiate opening .jpg file
     */
    public void onOpenButtonClicked() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        InputStream file = new FileInputStream(fileChooser.showOpenDialog(Main.window));
//        File file = fileChooser.showOpenDialog(Main.window);

        try {
            Image img = new Image(file);
            onClearButtonClicked();
            GCTool.drawImage(img, 0, 0);
        } catch (Exception ex) {
            System.out.printf("Error %s occurred", ex);
        }
    }

    public void onBrushButtonClicked(){
        selectedTool = brushTool;
        colorPicker = brushColorPicker;
    }

    public void onRectangleButtonClicked(){
        selectedTool = rectangleTool;
        colorPicker = rectangleColorPicker;
        isFilled = rectangleFilled;
    }

    public void onEllipseButtonClicked(){
        selectedTool = ellipseTool;
        colorPicker = ellipseColorPicker;
        isFilled = ellipseFilled;
    }

    ColorPicker getColorPicker() {
        return colorPicker;
    }
}

package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

/**
 * Paint tools.
 */
public class PaintTools {

    /**
     * Tool for painting a line.
     */
    public static class BrushTool implements PaintTool {

        @Override
        public void onMousePressed(MouseEvent event, Controller controller) {
            controller.GCTool.beginPath();
            controller.GCTool.moveTo(event.getX(), event.getY());
            controller.GCTool.setStroke(controller.getColorPicker().getValue());
            controller.GCTool.stroke();
        }

        @Override
        public void onMouseDragged(MouseEvent event, Controller controller) {
            controller.GCTool.lineTo(event.getX(), event.getY());
            controller.GCTool.setStroke(controller.getColorPicker().getValue());
            controller.GCTool.stroke();
        }

        @Override
        public void onMouseReleased(MouseEvent event, Controller controller) {

        }

    }
//
//    /**
//     * Tool for painting a rectangle.
//     */
//    public static class RectangleTool implements PaintTool {
//
//        @Override
//        public void onMousePressed(MouseEvent event, Canvas canvas) {
//
//        }
//
//        @Override
//        public void onMouseDragged(MouseEvent event, Canvas canvas) {
//
//        }
//
//        @Override
//        public void onMouseReleased(MouseEvent event, Canvas canvas) {
//
//        }
//    }
//
//    /**
//     * Tool for painting an ellipse.
//     */
//    public static class EllipseTool implements PaintTool {
//
//
//        @Override
//        public void onMousePressed(MouseEvent event, Canvas canvas) {
//
//        }
//
//        @Override
//        public void onMouseDragged(MouseEvent event, Canvas canvas) {
//
//        }
//
//        @Override
//        public void onMouseReleased(MouseEvent event, Canvas canvas) {
//
//        }
//    }

}

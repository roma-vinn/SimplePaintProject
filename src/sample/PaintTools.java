package sample;

import javafx.scene.input.MouseEvent;

/**
 * Paint tools.
 */
class PaintTools {

    /**
     * Tool for painting a line.
     */
    public static class BrushTool implements PaintTool {

        @Override
        public void onMousePressed(MouseEvent event, Controller controller) {
            controller.GCTool.beginPath();
            controller.GCTool.moveTo(event.getX(), event.getY());
            controller.GCTool.setStroke(controller.colorPicker.getValue());
            controller.GCTool.setLineWidth(controller.toolSize.getValue());
            controller.GCTool.stroke();
        }

        @Override
        public void onMouseDragged(MouseEvent event, Controller controller) {
            controller.GCTool.lineTo(event.getX(), event.getY());
            controller.GCTool.stroke();
        }

        @Override
        public void onMouseReleased(MouseEvent event, Controller controller) {

        }

    }

    /**
     * Tool for painting a rectangle.
     */
    public static class RectangleTool implements PaintTool {
        double x_start, y_start;

        @Override
        public void onMousePressed(MouseEvent event, Controller controller) {
            x_start = event.getX();
            y_start = event.getY();
        }

        @Override
        public void onMouseDragged(MouseEvent event, Controller controller) {

        }

        @Override
        public void onMouseReleased(MouseEvent event, Controller controller) {
            double x_finish = event.getX();
            double y_finish = event.getY();

            double x, y, width, height;
            x = Math.min(x_start, x_finish);
            y = Math.min(y_start, y_finish);

            width = Math.abs(x_start - x_finish);
            height = Math.abs(y_start - y_finish);

            if (controller.isFilled.isSelected()) {
                controller.GCTool.setFill(controller.colorPicker.getValue());
                controller.GCTool.fillRect(x, y, width, height);
            } else {
                controller.GCTool.setLineWidth(controller.toolSize.getValue());
                controller.GCTool.setStroke(controller.colorPicker.getValue());
                controller.GCTool.strokeRect(x, y, width, height);
            }

        }
    }

    /**
     * Tool for painting an ellipse.
     */
    public static class EllipseTool implements PaintTool {
        double x_start, y_start;

        @Override
        public void onMousePressed(MouseEvent event, Controller controller) {
            x_start = event.getX();
            y_start = event.getY();
        }

        @Override
        public void onMouseDragged(MouseEvent event, Controller controller) {

        }

        @Override
        public void onMouseReleased(MouseEvent event, Controller controller) {
            double x_finish = event.getX();
            double y_finish = event.getY();

            double x, y, width, height;
            x = Math.min(x_start, x_finish);
            y = Math.min(y_start, y_finish);

            width = Math.abs(x_start - x_finish);
            height = Math.abs(y_start - y_finish);
            if (controller.isFilled.isSelected()) {
                controller.GCTool.setFill(controller.colorPicker.getValue());
                controller.GCTool.fillOval(x, y, width, height);
            } else {
                controller.GCTool.setLineWidth(controller.toolSize.getValue());
                controller.GCTool.setStroke(controller.colorPicker.getValue());
                controller.GCTool.strokeOval(x, y, width, height);
            }
        }
    }

}

package exercise10;

import java.lang.Math;

public class Ellipse extends Figure {


    public Ellipse() {
       super(new Point(0,0), 1,1);
    }

    public Ellipse(Point startPoint, double side1, double side2) {
        super(new Point(startPoint), side1, side2);
    }

    public Ellipse(Ellipse otherEllipse) {
        super(new Point(otherEllipse.startPoint), otherEllipse.side1, otherEllipse.side2);
    }


    @Override
    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side1 + side2) - Math.sqrt((3.0 * side1 + side2) * (side1 + 3.0 * side2)));
    }

    @Override
    public double calculateArea() {
        return Math.PI * side1 * side2;
    }

    @Override
    public String getType() {
        return (side1 == side2) ? "Circle" : "Ellipse";
    }


    @Override
    public boolean equal(Figure otherFigure) {
        boolean sameA = Utils.equals(side1, otherFigure.side1);
        boolean sameB = Utils.equals(side2, otherFigure.side2);
        boolean sameAReversed = Utils.equals(side1, otherFigure.side2);
        boolean sameBReversed = Utils.equals(side2, otherFigure.side1);

        return (sameA && sameB) || (sameAReversed && sameBReversed);
    }

    public boolean containsClick(Point click) {
        double xce = startPoint.x + side1/2;
        double yce = startPoint.y + side2/2;

        if ((Math.pow(click.x - xce, 2)/Math.pow(side1,2)) + (Math.pow(click.y - yce, 2)/Math.pow(side2,2)) <= 1 ) {
            return true;
        }
        return false;
    }
}
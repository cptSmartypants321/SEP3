package onlinelibrary.onlib.Shared;

public class Rating {

    private double rating= 0;
    private double numberOfRating = 0;
    private double totalRating = 0;


    public Rating(double rating, double numberOfRating){
        this.rating = rating;
        this.numberOfRating = numberOfRating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getNumberOfRating() {
        return numberOfRating;
    }

    public void setNumberOfRating(double numberOfRating) {
        this.numberOfRating = numberOfRating;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = totalRating;
    }
}

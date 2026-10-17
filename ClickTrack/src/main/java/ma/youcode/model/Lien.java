package ma.youcode.model;

import java.util.concurrent.atomic.AtomicLong;

public class Lien {

    private Long id;
    private String offre;
    private String urlDestination;
   private long clicks = 0;
    private Long publisherId;

    public Lien() {
    }

    public Lien(Long id, String offre, String urlDestination,
                Long publisherId) {
        this.id = id;
        this.offre = offre;
        this.urlDestination = urlDestination;
        this.publisherId = publisherId;
    }

   public synchronized void incrementerClicks() {
    clicks++;
}

    public synchronized long getClicks() {
        return clicks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getUrlDestination() {
        return urlDestination;
    }

    public void setUrlDestination(String urlDestination) {
        this.urlDestination = urlDestination;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

}

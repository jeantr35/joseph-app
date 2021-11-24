package co.com.sofka.cargame.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Angle {

    @Id
    private String id;
    private float xAngle;
    private float yAngle;
    private float zAngle;
    private Boolean badCervical;
    private Boolean badToraxica;
    private Boolean badLumbar;

    public Boolean getBadCervical() {
        return badCervical;
    }

    public void setBadCervical(Boolean badCervical) {
        this.badCervical = badCervical;
    }

    public Boolean getBadToraxica() {
        return badToraxica;
    }

    public void setBadToraxica(Boolean badToraxica) {
        this.badToraxica = badToraxica;
    }

    public Boolean getBadLumbar() {
        return badLumbar;
    }

    public void setBadLumbar(Boolean badLumbar) {
        this.badLumbar = badLumbar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getxAngle() {
        return xAngle;
    }

    public void setxAngle(float xAngle) {
        this.xAngle = xAngle;
    }

    public float getyAngle() {
        return yAngle;
    }

    public void setyAngle(float yAngle) {
        this.yAngle = yAngle;
    }

    public float getzAngle() {
        return zAngle;
    }

    public void setzAngle(float zAngle) {
        this.zAngle = zAngle;
    }
}

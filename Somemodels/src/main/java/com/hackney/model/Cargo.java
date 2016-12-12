package com.hackney.model;

import java.util.List;

/**
 * Created by clhackne on 05/08/2016.
 */
public class Cargo {

    private String cargoDescription;

    private String id;

    private String destinationSpacePort;

    private String originSpacePort;

    private int             status;

    public Cargo() {

    }

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinationSpacePort() {
        return destinationSpacePort;
    }

    public void setDestinationSpacePort(String destinationSpacePort) {
        this.destinationSpacePort = destinationSpacePort;
    }

    public String getOriginSpacePort() {
        return originSpacePort;
    }

    public void setOriginSpacePort(String originSpacePort) {
        this.originSpacePort = originSpacePort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

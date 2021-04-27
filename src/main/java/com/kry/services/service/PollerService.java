package com.kry.services.service;

import com.kry.services.model.PollerModel;

import java.util.List;

public interface PollerService {

    void createServices(PollerModel pollerModel);

    List<PollerModel> getServices();

    void delete(int id);
}

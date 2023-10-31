package com.loyallinkup.loyallinkup.service.impl;

import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.Client;
import com.loyallinkup.loyallinkup.model.Points;

import com.loyallinkup.loyallinkup.model.dto.PointsDto;
import org.springframework.stereotype.Service;
import com.loyallinkup.loyallinkup.repo.BusinessRepo;
import com.loyallinkup.loyallinkup.repo.ClientRepo;
import com.loyallinkup.loyallinkup.repo.PointsRepo;
import com.loyallinkup.loyallinkup.service.PointsService;

import java.util.List;
import java.util.Optional;
@Service
public class PointsServiceImpl implements PointsService
{

    private final PointsRepo pointsRepo;
    private final BusinessServiceImpl businessService;
    private final ClientServiceImpl clientService;

    public PointsServiceImpl(PointsRepo pointsRepo, BusinessRepo businessRepo, ClientRepo clientRepo, ClientRepo clientRepo1, BusinessRepo businessRepo1, BusinessServiceImpl businessService, ClientServiceImpl clientService) {
        this.pointsRepo = pointsRepo;
        this.businessService = businessService;
        this.clientService = clientService;
    }

    @Override
    public List<Points> listAll() {
        return this.pointsRepo.findAll();
    }

    @Override
    public Optional<Points> findById(Long points_id) {
        return this.pointsRepo.findById(points_id);
    }

    @Override
    public Points create(Long points_id, PointsDto pointsDto) {

        Client client = this.clientService.findById(pointsDto.getClient_id()).get();
        Business business = this.businessService.findById(pointsDto.getBusiness_id());

        Points points = new Points(points_id, pointsDto.getLoyal_points(), pointsDto.getLoyal_awards(), client, business);
        return this.pointsRepo.save(points);
    }

    @Override
    public Points edit(Long points_id, PointsDto pointsDto) {

        Points points = this.pointsRepo.findById(points_id).get();
        Client client = this.clientService.findById(pointsDto.getClient_id()).get();
        Business business = this.businessService.findById(pointsDto.getBusiness_id());

        points.setPoints_id(points_id);
        points.setLoyal_points(pointsDto.getLoyal_points());
        points.setLoyal_awards(points.getLoyal_awards());
        points.setBusiness(business);
        points.setClient(client);


        return this.pointsRepo.save(points);
    }


    @Override
    public Boolean delete(Long points_id) {

        if(this.pointsRepo.findById(points_id).isPresent()){
            this.pointsRepo.deleteById(points_id);
            return true;
        }else
            return false;
    }
}

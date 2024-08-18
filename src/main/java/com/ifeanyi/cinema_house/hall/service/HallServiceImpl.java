package com.ifeanyi.cinema_house.hall.service;

import com.ifeanyi.cinema_house.admin.service.AdminService;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.model.HallModel;
import com.ifeanyi.cinema_house.hall.repository.HallRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepo repo;
    private final AdminService adminService;

    @Override
    public Hall create(HallModel hallModel) throws NotFoundExceptionHandler {

        Hall hall = new Hall();

        BeanUtils.copyProperties(hallModel, hall);

        return repo.save(hall);
    }

    @Override
    public Hall get(String id) throws NotFoundExceptionHandler {
        return repo.findById(id).orElseThrow(() -> new NotFoundExceptionHandler("No hall found with id: " + id));
    }

    @Override
    public List<Hall> findByShowingId(String showingId, Pageable pageable) {
        return repo.findByShowingId(showingId, pageable).toList();
    }

    @Override
    public Hall findByHallNumber(Integer hallNumber) throws NotFoundExceptionHandler {
        return repo.findByHallNumber(hallNumber).orElseThrow(() -> new NotFoundExceptionHandler("No hall found with hall number: " + hallNumber));
    }

    @Override
    public Hall update(String id, HallModel hallModel) throws NotFoundExceptionHandler {

        Hall hall = get(id);
        hall.setHallNumber(hallModel.getHallNumber() != null ? hallModel.getHallNumber() : hall.getHallNumber());
        hall.setAvailableSeat(hallModel.getAvailableSeat() != null ? hallModel.getAvailableSeat() : hall.getAvailableSeat());
        hall.setShowingId(hallModel.getShowingId() != null ? hallModel.getShowingId() : hall.getShowingId());
        hall.setSoldSeat(hallModel.getSoldSeat() != null ? hallModel.getSoldSeat() : hall.getSoldSeat());

        return repo.save(hall);
    }

    @Override
    public void delete(String admin, String id) throws NotFoundExceptionHandler {
        adminService.get(admin);
        repo.delete(get(id));
    }

}
package com.ifeanyi.cinema_house.showing.service;

import com.ifeanyi.cinema_house.admin.service.AdminService;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.showing.entity.Showing;
import com.ifeanyi.cinema_house.showing.model.ShowingModel;
import com.ifeanyi.cinema_house.showing.repository.ShowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowingServiceImpl implements ShowingService {

    private final ShowingRepository showingRepo;
    private final AdminService adminService;

    @Override
    public Showing create(ShowingModel showingModel) throws NotFoundExceptionHandler {

        Showing showing = new Showing();
        BeanUtils.copyProperties(showingModel,showing);
        showing.setCreatedByAdmin(showingModel.getAdminId());
        showing.setUpdatedByAdmin(showingModel.getAdminId());

        return showingRepo.save(showing);
    }

    @Override
    public Showing get(String id) throws NotFoundExceptionHandler {
        return showingRepo.findById(id).orElseThrow(() -> new NotFoundExceptionHandler("No hall found with id: " + id));
    }

    @Override
    public List<Showing> findAll(Pageable pageable) {
        return showingRepo.findAll();
    }

    @Override
    public Showing update(String id, ShowingModel showingModel) throws NotFoundExceptionHandler {

        Showing showing = get(id);
        showing.setHallId(showingModel.getHallId() != null ? showingModel.getHallId() : showing.getHallId());
        showing.setShowingTime(showingModel.getShowingTime() != null ? showingModel.getShowingTime() : showing.getShowingTime());
        showing.setUpdatedByAdmin(showingModel.getAdminId() != null ? showingModel.getAdminId() : showing.getUpdatedByAdmin());
        showing.setMoveId(showingModel.getMoveId() != null ? showingModel.getMoveId() : showing.getMoveId());

        return showingRepo.save(showing);
    }

    @Override
    public void delete(String admin, String id) throws NotFoundExceptionHandler {
        adminService.get(admin);
        showingRepo.delete(get(id));
    }
}

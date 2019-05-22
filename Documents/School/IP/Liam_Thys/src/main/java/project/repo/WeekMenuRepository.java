package project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.WeekMenu;

@Repository
public interface WeekMenuRepository extends JpaRepository<WeekMenu,Integer> {
    WeekMenu findWeekMenuByWeekNr(int id);
}
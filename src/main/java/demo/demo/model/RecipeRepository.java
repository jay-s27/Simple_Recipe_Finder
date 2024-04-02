package demo.demo.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipes, Integer> {
    Optional<Recipes> findByTitleContaining(String title);

    @Query("select r.id from Recipes r order by r.id desc limit 1")
    Optional<Integer> findLastPost();
  }
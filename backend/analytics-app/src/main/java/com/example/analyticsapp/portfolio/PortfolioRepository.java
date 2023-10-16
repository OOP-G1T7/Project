package com.example.analyticsapp.portfolio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Integer>{

    @Query(value = "SELECT * FROM portfolio", nativeQuery = true)
    ArrayList<PortfolioEntity> getAll();

    /**
     * Find all portfolios.
     *
     * @return A list of portfolios if found, or null if not found.
     */
    @Query(value = "SELECT * FROM portfolio WHERE user_id = ?", nativeQuery = true)
    ArrayList<PortfolioEntity> getAllPortfolios(int userId);
    

    /**
     * Find portfolio based on its id.
     *
     * @param portfolioId The portfolio id to search for.
     * @return The portfolio if found, or null if not found.
     */
    @Query(value = "SELECT * FROM portfolio WHERE portfolio_id = ?", nativeQuery = true)
    PortfolioEntity getOnePortfolio(int portfolioId);


    /**
     * Find portfolio based on its id.
     *
     * @param portfolioId The portfolio id to search for.
     * @return The portfolio if found, or null if not found.
     */
    @Query("SELECT p FROM PortfolioEntity p LEFT JOIN FETCH p.stocks WHERE p.portfolioId = :portfolioId")
    PortfolioEntity getPortfolioWithStocks(@Param("portfolioId") int portfolioId);
    
}

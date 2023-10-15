package com.example.analyticsapp.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.analyticsapp.portfolio.PortfolioRepository;

@Service
public class PortfolioServiceImplementation extends PortfolioService{

    @Autowired
    private PortfolioRepository portfolioRepo;    

    @Override
    public PortfolioEntity createPortfolio(int userId, String name, String description) {
        PortfolioEntity newPortfolio = new PortfolioEntity();
        newPortfolio.setName(name);
        newPortfolio.setUserId(userId);
        newPortfolio.setDescription(description);
        return portfolioRepo.save(newPortfolio);
    }

    @Override
    public PortfolioEntity retrievePortfolio(int portfolioId) {
        PortfolioEntity retrieved = portfolioRepo.getPortfolio(portfolioId);
        return retrieved;
    }

    @Override
    public void editPortfolio(int portfolioId, int userId, String name, String description) {
        PortfolioEntity retrieved = portfolioRepo.getPortfolio(portfolioId);
        retrieved.setDescription(description);
        retrieved.setName(name);
        portfolioRepo.save(retrieved);
    }
}
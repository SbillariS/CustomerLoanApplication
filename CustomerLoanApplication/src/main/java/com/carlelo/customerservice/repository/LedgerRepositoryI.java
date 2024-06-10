package com.carlelo.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.customerservice.model.Ledger;
@Repository
public interface LedgerRepositoryI extends JpaRepository<Ledger,Integer>
{

}

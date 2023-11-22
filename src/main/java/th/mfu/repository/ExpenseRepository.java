package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

}

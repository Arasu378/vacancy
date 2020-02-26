package com.arasu.vacancy.candidate.repository;

import com.arasu.vacancy.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
		/*Optional<Candidate> findById(Integer id);
		List<Candidate> findCandidateByUserId(Integer id);
		List<Candidate> findAllCandidate();
		*/
}

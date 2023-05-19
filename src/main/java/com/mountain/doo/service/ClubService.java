package com.mountain.doo.service;

import com.mountain.doo.dto.ClubDetailResponseDTO;
import com.mountain.doo.dto.ClubListResponseDTO;
import com.mountain.doo.dto.ClubWriteRequestDTO;
import com.mountain.doo.dto.page.ClubSearch;
import com.mountain.doo.entity.Club;
import com.mountain.doo.repository.ClubMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubMapper clubRepository; //mybatis 사용시


    // 중간처리 기능 자유롭게 사용
    // 목록 중간처리
    public List<ClubListResponseDTO> getList(ClubSearch page) {

        return clubRepository.findAll(page)
                .stream()
                .map(club -> new ClubListResponseDTO(club))
                .collect(toList())
                ;
    }
//    public List<ClubListResponseDTO> getList() {
//
//        return clubRepository.findAll()
//                .stream()
//                .map(club -> new ClubListResponseDTO(club))
//                .collect(toList())
//                ;
//    }

    // 글 등록 중간처리
    public boolean register(ClubWriteRequestDTO dto) {
        return clubRepository.save(new Club(dto));
    }
    
    // 글 삭제 중간처리
    public boolean delete(int bno) {
        return clubRepository.deleteByNo(bno);
    }

    //글 상세조회 중간처리
    public ClubDetailResponseDTO getDetail(int bno) {

        Club club = clubRepository.findOne(bno);
        // 조회수 상승 처리
//        clubRepository.upViewCount(bno); //mybatis-sql 사용시

        return new ClubDetailResponseDTO(club);
    }
    //조회수 중간 처리
    public int getCount(ClubSearch clubSearch) {
//        return clubRepository.count(search);
        return clubRepository.count(clubSearch);
    }

}

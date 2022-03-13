package com.hello.penguin.Service;

import com.hello.penguin.Domain.Member;
import com.hello.penguin.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long getMemberCount() {
        return memberRepository.count();
    }

    public Page<Member> getAllMember(int start, int length) {
        return memberRepository.findAll(PageRequest.of((start + 1) / length, length));
    }

    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }
}

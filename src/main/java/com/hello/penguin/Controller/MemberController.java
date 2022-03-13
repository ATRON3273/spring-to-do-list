package com.hello.penguin.Controller;

import com.hello.penguin.Domain.Member;
import com.hello.penguin.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {
    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/message")
    public String testByResponseBody() {
        String message = "안녕하세요. 잠시 후에 화면에서 만나요!";
        return message;
    }

    @GetMapping("/member")
    public String getMemberPage() {
        return "memberList";
    }


    @GetMapping("/member/list")
    @ResponseBody
    public Map<String, Object> getAllMember(@RequestParam("start") int start, @RequestParam("length") int length) {
        Page<Member> memberList = memberService.getAllMember(start, length);
        Long recordsTotal = memberService.getMemberCount();
        Long recordsFiltered = memberService.getMemberCount();

        Map<String, Object> data = new HashMap<>();

        data.put("memberList", memberList);
        data.put("recordsTotal", recordsTotal);
        data.put("recordsFiltered", recordsFiltered);

        return data;
    }
}

package own.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import own.login.domain.Member;
import own.login.repository.MemberRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        if (memberRepository.findByLoginId(member.getLoginId()) != null) {
            return null;
        }
        return memberRepository.save(member);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member checkMember(Member member) {
        // 인자로 받은 Member의 LoginId와 LoginPasswd가 db정보와 일치하는지 확인.
        Member findMember = findByLoginId(member.getLoginId());
        if (findMember != null) {
            if (member.getLoginPasswd().equals(findMember.getLoginPasswd())) {
                return findMember;
            }
        }
        return null;
    }

    @Override
    public Member findByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId);
    }

    @Override
    public void clear() {
        memberRepository.clear();
    }

    private void memberOverlappingCheck(Member member) {
        if (memberRepository.findByLoginId(member.getLoginId()) != null) {
                    throw new IllegalStateException("LoginId 중복!");
                    // 부정 또는 부적절한 때에 메서드가 불려 간 것을 나타냄
        }
    }
}

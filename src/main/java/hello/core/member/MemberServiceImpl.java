package hello.core.member;


// Member Service에 대한 구현체
public class MemberServiceImpl implements MemberService{

    // 디형성의 현장 : 부모 참조변수에 자식 인스턴스가 참조됨
    // memberRepository는 인터페이스, MemoryMemberRepository는 그것을 구현한 구현체
    // MemoryRepository에서 memberRepository(인터페이스)의 메소드를 오버라이딩했다면 그 메소드를 사용할 수 있음
    private final MemberRepository memberRepository;

    // 생성자를 통해 memberRepository의 구현체가 뭐가 들어가는 지가 결정됨
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

window.addEventListener("DOMContentLoaded", function(){

    const modalClose = document.querySelector('.ModalClose');
    modalClose.addEventListener('click', () => {
        // 닫기 버튼 클릭 시 모달창 이벤트
        document.querySelector('body').classList.remove('Modal');
        document.querySelector('.ModalWrapper').classList.remove('Modal'); // 사라지는 이벤트가 끝난 후 모달창 제거해야 함(0.5초후)
        buttonLogin.style.zIndex = '9999'; // 개발 과정에선 무시
    });

    const loginInput = document.querySelectorAll('.InputFull');
    loginInput.forEach((e) => {
        // input focus, focusout 이벤트
        e.addEventListener('focus', function () {
            const children = this.parentNode.children;
            this.classList.add('On'); // input에 포커스효과, error상태시 On 대신 Error 클래스 추가
            children[1].classList.add('On'); // label에 포커스효과, error상태시 On 대신 Error 클래스 추가
            this.parentNode.lastElementChild.classList.add('On'); // InputTxt show, error상태시 On 대신 Error 클래스 추가

            if (this.value) {
                children[2].classList.add('On');

                if (this.classList.contains('Password')) {
                    children[3].classList.add('Over');
                }
            }
        });
        e.addEventListener('blur', function () {
            const children = this.parentNode.children;
            this.parentNode.lastElementChild.classList.remove('On'); // InputTxt hide, error상태시 On 대신 Error 클래스 제거
            this.classList.remove('Over'); // input지우기버튼, password보기버튼 hide

            if (!this.value) {
                this.classList.remove('On'); // input, label에 포커스아웃효과, error상태시 On 대신 Error 클래스 제거
                children[1].classList.remove('On');
                children[2].classList.remove('On');

                if (this.classList.contains('Password')) {
                    children[3].classList.remove('Over');
                }
            }
        });

        e.addEventListener('keydown', function () {
            const children = this.parentNode.children;

            if (this.value) {
                children[2].classList.add('On');
                if (this.classList.contains('Password')) {
                    children[3].classList.add('Over');
                }
            } else {
                children[2].classList.remove('On');
                if (this.classList.contains('Password')) {
                    children[3].classList.remove('Over');
                }
            }
        });
    });

    const inputDel = document.querySelectorAll('.InputDel');
    inputDel.forEach((e) => {
        // input 지우기 버튼 클릭 이벤트
        e.addEventListener('mousedown', function (event) {
            event.preventDefault();
            this.parentNode.firstElementChild.value = '';
            this.classList.remove('On'); // error상태시 On 대신 Error 클래스 제거
            this.parentNode.firstElementChild.blur();
            this.parentNode.firstElementChild.focus(); // input 지운 후 바로 포커스되도록
            passwordShow.classList.remove('Over');
        });
    });

    const arrow = document.querySelector(".ModalArrow");
    arrow.addEventListener("click", function(){
        contentPassword.classList.remove("On");
    });


    const buttonGo = document.querySelector(".ButtonGo");
    const contentPassword = document.querySelector(".ContentPassword");
    buttonGo.addEventListener("click", function(){ //비밀번호 찾기 누를 때 이벤트
        contentPassword.classList.add("On");
        this.style.display = "none";
    });

    
});
import React, { useCallback } from 'react';
import { useRecoilValue } from 'recoil';
import styled, { css, keyframes } from 'styled-components';
import IconFlag from '../../../assets/images/IconFlag.png';
import Profile1 from '../../../assets/images/Profile1.png';
import { nickNameState, uploadFileImgState } from '../../../atom/register';
import Button from '../../../components/common/Button';

function SignupSection4({ IsClick, closeModal, HandleClick }) {
  const nickName = useRecoilValue(nickNameState);
  const fileimg = useRecoilValue(uploadFileImgState);

  const HandleComplete = useCallback((e) => {
    e.preventDefault();
    closeModal();
    setTimeout(() => {
      HandleClick(0);
    }, 500);
  }, []);

  return (
    <SignupContents active={IsClick === 4}>
      <ResultFlag src={IconFlag} alt="IconFlag" />
      <ResultProfileWrapper>
        <ResultProfile>
          <img src={Profile1} alt="" />
        </ResultProfile>
        <ResultTitle>
          <b>
            <span>{nickName}</span>
            {'님, '}
          </b>
          환영해요!
        </ResultTitle>
        <ResultTxt>
          {' 회원가입을 성공적으로 마쳤어요.'}
          <br />
          {' 크루크루와 함께 힘차게 출발해봐요~!'}
        </ResultTxt>
      </ResultProfileWrapper>
      <Button size="fullregular" color="darkblue" onClick={HandleComplete}>
        확인
      </Button>
    </SignupContents>
  );
}

export default SignupSection4;

const FadeIn = keyframes`
    from{
        opacity:0;
    } to {
        opacity:1;
    }
`;

const Flag = keyframes`
    0%{
        top: 27px;
    } 100% {
        top:-33px;
    }
`;
const SignupContents = styled.div`
  transition: 0.5s;
  position: relative;
  display: none;

  animation-duration: 0.5s;
  animation-timing-function: ease-out;

  animation-fill-mode: forwards;

  ${(props) =>
    props.active &&
    css`
      display: block;
      animation-name: ${FadeIn};
    `}
`;

const ResultProfileWrapper = styled.div`
  overflow-y: auto;
  overflow-x: hidden;
  position: relative;
  scroll-behavior: smooth;
`;

const ResultFlag = styled.img`
  width: 27px;
  position: absolute;
  top: 27px;
  left: calc(50% - 2px);
  animation: ${Flag} 1s forwards;
`;

const ResultProfile = styled.div`
  width: 200px;
  height: 200px;
  border-radius: 50%;
  overflow: hidden;
  background-color: #00b7ff;
  z-index: 1;
  margin: 0 auto;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;

const ResultTitle = styled.h2`
  font-size: 32px;
  text-align: center;
  margin: 22px 0 29px;
  font-weight: 300;
  color: #000;

  b {
    font-weight: 700;
  }
`;

const ResultTxt = styled.p`
  font-size: 13px;
  text-align: center;
  margin-bottom: 60px;
  font-weight: 400;
  line-height: 24px;
  color: #000;
`;

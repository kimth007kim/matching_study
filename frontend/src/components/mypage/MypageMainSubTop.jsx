import React from 'react';
import styled from 'styled-components';
import ArrowCircle from '@/assets/images/ArrowCircle.png';

function MypageMainSubTop({ total = 0, studyCnt = 0, hobbyCnt = 0 }) {
  return (
    <section>
      <Wrapper>
        <h3>내가 참여요청한 크루</h3>
        <p>내가 참여요청한 크루의 현황을 이곳에서 확인하고 관리하세요!</p>
        <Content>
          <h4>
            전체
            <span> {total}개</span>
          </h4>
          <BoxWrap>
            <SentBox color="#0575e6" hoverColor="#005ec5">
              <p>{studyCnt}개</p>
              <p>스터디 크루</p>
              <div className="arrow"></div>
            </SentBox>
            <SentBox color="#ffd458" hoverColor="#fcb90d">
              <p>{hobbyCnt}개</p>
              <p>취미 크루</p>
              <div className="arrow"></div>
            </SentBox>
          </BoxWrap>
        </Content>
      </Wrapper>
    </section>
  );
}

export default MypageMainSubTop;

const Wrapper = styled('div')`
  max-width: 850px;
  margin: auto;
  position: relative;
  padding-top: 36px;

  h3 {
    font-size: 20px;
    font-weight: 700;
  }

  p {
    margin-top: 8px;
    font-size: 13px;
    color: #868686;
    font-weight: 400;
    line-height: 20px;
  }
`;

const Content = styled('div')`
  padding: 45px 0 100px;

  h4 {
    font-size: 42px;
    font-weight: 700;
    text-align: center;
    padding-bottom: 50px;

    span {
      color: #00b7ff;
    }
  }
`;

const BoxWrap = styled('div')`
  display: flex;
  gap: 48px;
  justify-content: space-between;
`;

const SentBox = styled('div')`
  width: 100%;
  height: 180px;
  border-radius: 10px;
  box-shadow: 5px 5px 10px rgb(0 0 0 / 10%);
  display: flex;
  justify-content: center;
  align-items: flex-start;
  flex-direction: column;
  cursor: pointer;
  transition: 1s;
  padding: 0 32px;
  position: relative;
  background-color: ${(props) => props.color};

  p {
    color: #fff;
    line-height: 1;
    width: 100%;
    text-align: center;
    transition: 0.5s;

    &:nth-child(1) {
      font-size: 48px;
      font-weight: 700;
    }
    &:nth-child(2) {
      font-size: 18px;
      font-weight: 500;
      margin-top: 22px;
    }
  }

  .arrow {
    width: 55px;
    height: 55px;
    background: url(${ArrowCircle}) center/55px 55px;
    position: absolute;
    bottom: calc(50% - 28px);
    right: 65px;
    transition: 0.5s;
    transition-delay: 0s;
    opacity: 0;
  }

  :hover {
    background-color: ${(props) => props.hoverColor};

    p {
      width: 170px;
    }

    .arrow {
      opacity: 1;
      transition-delay: 0.1s;
    }
  }
`;
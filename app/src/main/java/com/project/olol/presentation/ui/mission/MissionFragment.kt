package com.project.olol.presentation.ui.mission

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.olol.R
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MissionFragment(hasMissions: Boolean, missionCount: Int = 0) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        // 로고와 알림 벨
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_olol),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }

        // 캐릭터 이미지
        Image(
            painter = painterResource(id = R.drawable.character_olol),
            contentDescription = "Character",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )

        // 미션 상태 텍스트
        Text(
            text = if (hasMissions) "참여중인 미션은 ${missionCount}개에요!" else "참여중인 미션이 없어요!",
            fontSize = 15.sp,
            fontWeight = if (hasMissions) FontWeight.Bold else FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        if (hasMissions) {
            MissionCardList(missionCount)
        } else {
            EmptyMissionUI()
        }
    }
}

@Composable
fun EmptyMissionUI() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
    ) {
        // 콕 찌르기 카드
        ActionCard(
            text = "가족 / 친구에게 👉🏻 콕 찌르기로 미션을 요청해보세요!",
            buttonText = "콕 찌르기"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 내가 보낸 미션 카드
        ActionCard(
            text = "아직 보낸 미션이 없어요!",
            buttonText = "미션 보내러 가기"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 완료한 미션 보러가기 버튼
        TextButton(onClick = { /* TODO: onClick 액션 */ }) {
            Text(
                text = "완료한 미션 보러가기",
                color = Color.Gray,
                fontSize = 15.sp,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun MissionCardList(missionCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
    ) {
        repeat(missionCount) {
            MissionCard(missionTitle = "미션 $it", personName = "김태우", dDay = "D-10")
            Spacer(modifier = Modifier.height(8.dp))
        }

        // 내가 보낸 미션 리스트
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "내가 보낸 미션", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = { /* TODO: Add action */ }) {
                Text(
                    text = "더보기",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }

        // 여기서도 마찬가지로 내가 보낸 미션 카드를 나열할 수 있습니다.
        MissionCard(missionTitle = "반 1등하기", personName = "아빠/김태우", dDay = "D-30")

        Spacer(modifier = Modifier.height(16.dp))

        // 완료한 미션 보러가기 버튼
        TextButton(onClick = { /* TODO: Add action */ }) {
            Text(
                text = "완료한 미션 보러가기",
                color = Color.Gray,
                fontSize = 15.sp,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun ActionCard(text: String, buttonText: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { /* TODO: Add action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E2F34)),
            modifier = Modifier.padding(4.dp)
        ) {
                Text(
                    text = buttonText,
                    color = Color(0xFF4AF5C2),
                    fontSize = 15.sp
                )
//            Text( // TODO : Compose에서 텍스트에 그라데이션 적용이 안 된다고 함.. 방법을 찾아봐야함
//                text = buttonText,
//                color = Brush.linearGradient(
//                    colors = listOf(Color(0xFF5ACED5), Color(0xFF26E9F4))
//                ),
//                fontSize = 15.sp
//            )
        }
    }
}

@Composable
fun MissionCard(missionTitle: String, personName: String, dDay: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(4.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(4.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = missionTitle, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "Arrow",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = personName, fontSize = 12.sp, color = Color.Gray)
            CustomProgressBar(progress = 0.7f)
        }
    }
}

@Composable
fun CustomProgressBar(progress: Float) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .background(Color(0xFFEAEAEA)) // 백그라운드 색상
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress) // 프로그레스에 따라 너비 조정
                .height(8.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF26E9F4), Color(0xFF6AFF94))
                    )
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MissionFragmentPreview() {
    MissionFragment(hasMissions = true, missionCount = 2)
}

@Preview(showBackground = true)
@Composable
fun EmptyMissionFragmentPreview() {
    MissionFragment(hasMissions = false)
}

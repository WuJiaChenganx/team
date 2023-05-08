<template>
  <div>
    <div class="competitionTable">
      <el-table :data="tableData" border style="width: 80%">
        <el-table-column prop="name" label="比赛名称"></el-table-column>
        <el-table-column prop="student" label="项目负责人及成员">
        </el-table-column>
        <el-table-column prop="grade" label="等级"> </el-table-column>
        <el-table-column prop="teacher" label="指导老师"> </el-table-column>
      </el-table>
    </div>
    <!-- <img src="../assets/images/background/title-bg.png" alt="" /> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
        {
          id: 18,
          grade: "二等奖",
          name: "2022中国机器人大赛暨RoboCup机器人世界杯中国赛-机器人先进视觉赛-3D识别项目",
          teacher: "邱杰凡、姚信威",
          student: "丰泽辉、陈翰墨、杨正一、孙辰赫、盛嘉、屠恒彦、姜易臻",
        },
        {
          id: 20,
          grade: "一等奖",
          name: "2021中国机器人大赛机器人先进视觉赛-工业测量项目",
          teacher: "姚信威",
          student: "童文韬、沈根行、张宇健、刘硕、张扬、徐子艺、申屠琦超",
        },
        {
          id: 19,
          grade: "一等奖",
          name: "2021中国机器人大赛机器人先进视觉赛-3D识别项目",
          teacher: "姚信威",
          student: "刘硕、张扬、徐子艺、申屠琦超、童文韬、沈根行、张宇健",
        },
        {
          id: 23,
          grade: "三等奖",
          name: "2020年中国机器人大赛足球机器人RoboCup小型组",
          teacher: "姚信威",
          student: "赵雨舟、何海煜、孙博航、王炜博等",
        },
        {
          id: 21,
          grade: "冠军/一等奖",
          name: "2020年中国机器人大赛机器人先进视觉赛-3D识别项目",
          teacher: "姚信威",
          student: "陈兴迪、林泽、朱叙行、丁晨俊、杨振鑫等",
        },
        {
          id: 22,
          grade: "冠军/一等奖",
          name: "2020年中国机器人大赛机器人先进视觉赛-3D测量项目",
          teacher: "姚信威",
          student: "陈兴迪、林泽、朱叙行、丁晨俊、杨振鑫等",
        },
        {
          id: 25,
          grade: "冠军/一等奖",
          name: "2019中国机器人大赛先进视觉3D识别项目",
          teacher: "姚信威",
          student: "洪佳升、潘律翰、朱启月",
        },
        {
          id: 24,
          grade: "冠军/一等奖",
          name: "2019中国机器人大赛先进视觉3D测量项目",
          teacher: "姚信威",
          student: "洪佳升、潘律翰",
        },
        {
          id: 26,
          grade: "优胜奖",
          name: "2019RoboCup机器人世界杯中国赛",
          teacher: "姚信威",
          student: "王诗毅、俞淦、陈茵、王宇鹏、黄益明、郑铁驰、王炜博、王金泽",
        },
      ],
    };
  },
};
</script>

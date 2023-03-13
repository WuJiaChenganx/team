<template>
  <div class="academy">
    <div class="academyContent">
      <div class="academyTitle">
        <div class="title">学术动态</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }"
              >首页</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/academy' }"
              >学术动态</el-breadcrumb-item
            >
          </el-breadcrumb>
        </div>
      </div>
      <div class="academyItem">
        <div
          v-for="(item, index) in newsList"
          :key="index"
          class="academy-row"
          style="cursor: pointer"
          @click="gotoDetail(item)"
        >
          <div class="academy-date">
            <div>{{ item.day }}</div>
            <div>{{ item.date }}</div>
          </div>
          <div class="academy-profile">
            <div class="academy-title">{{ item.title }}</div>
            <div class="academy-thing">
              {{ item.profile }}
            </div>
          </div>
        </div>
      </div>
      <div class="paging">
        <!-- page-size展示的选择每页显示个数的选项,页面变动触发的事件是current-change后面的函数,total表示总共的数量 current-page表示当前页数-->
        <el-pagination
          background
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :page-size="5"
          :total="total_number"
          :current-page="current_index"
        >
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      title: "团队动态",
      currentMenu: "学术动态",
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
      // 要展示的新闻信息(加载前还要处理过)
      newsList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "NLP课题组2篇论文被ICLR 2023接收",
          paperName:
            "Fuzzy Alignments in Directed Acyclic Graph for Non-autoregressive Machine Translation",
          paperProfile:
            "非自回归机器翻译（Non-autoregressive Translation, NAT）显著降低了用户等待译文的延迟，但因为语言映射的多峰分布特性，往往性能较差。为此，一些研究者尝试将有向无环图（Directed Acyclic Graph, DAG）结构引入NAT系统，试图通过DAG建模输出字词之间的依赖来缓解多峰分布问题。这种系统一般通过极大似然估计的方式进行模型参数学习，以负对数似然（Negative Log Likelihood, NLL）作为损失函数。尽管上述方法取得了一定的成功，我们发现NLL隐式地要求了目标译文字词与DAG节点之间存在严格对齐关系，弱化了DAG学习多峰分布的能力。在本文中，我们考虑DAG中所有可能的路径与参考译文之间均存在某种模糊对齐关系。我们设计了一个模糊对齐指标以衡量图与译文的匹配程度，并以最大化该指标的方式进行参数学习。大量实验表明我们的方法显著地改善了NAT系统的翻译质量，在多个基于原始语料的NAT翻译任务上达到了最先进的性能。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NeurIPS 2022接收",
          profile:
            "2022年9月，自然语言处理组1篇论文被NeurIPS 2022接收。NeurIPS 2022的全称是Thirty-sixth Conference on Neural Information Processing Systems，是人工智能领域的顶级会议之一。NeurIPS 2022将于2022年11月28日-12月9日在美国新奥尔良举行。",
          detail:
            "非自回归翻译模型能够并行生成整句译文，在解码速度上具有非常大的优势，但由于交叉熵损失无法正确地评估模型的输出，非自回归模型的性能与自回归模型有很大差距。基于CTC损失的非自回归模型能够建模参考译文与模型输出的隐式对齐，因此大幅提升了非自回归模型的性能水平，目前已成为非自回归机器翻译的主流模型之一。然而，CTC损失最早是为语音识别任务设计的，只能建模参考译文与模型输出间的单调对齐，无法处理机器翻译中普遍存在的非单调对齐现象（如下图所示），这是非自回归机器翻译领域的一个open problem。在本文中，我们针对这个问题做了系统性的研究，将对齐空间扩展为非单调隐式对齐，并考虑所有与参考译文相关的对齐来计算损失。基于此，我们提出了基于二分图匹配和n元组匹配的两种解决方案，均能显著改善非自回归模型的翻译质量。在多个翻译数据集上，我们的最佳方法均达到了与自回归模型相当的性能，并保持着对自回归模型十倍以上的解码加速。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NAACL 2022接收",
          profile:
            "2022年4月，自然语言处理组1篇论文被NAACL 2022主会接收。NAACL 2022的全称是2022 Annual Conference of the North American Chapter of the Association for Computational Linguistics – Human Language Technologies (NAACL-HLT 2022)，是 ACL 的北美分会，自然语言处理领域的顶级会议之一。NAACL 2022将于2022年7月10日-15日在美国西雅图召开。",
          detail:
            "非自回归机器翻译模型存在多峰性问题：同一个源句可能有多个正确的译文，但模型只根据参考译文计算损失函数。对此，一种解决方案是序列级知识蒸馏，它通过将参考译文替换为自回归模型的输出，使目标端的译文更具确定性。然而，蒸馏后的数据集仍存在一定程度的多峰性，另外，向特定的自回归教师模型学习会限制模型能力的上限，从而约束了非自回归模型的潜力。在本文中，我们认为非自回归模型需要更多的参考译文来训练，并对此提出了多样蒸馏和译文选择的方法。具体地，我们首先通过不同随机种子训练多个教师模型，进行多样化的知识蒸馏，生成一个包含多个高质量参考译文的数据集。在训练非自回归模型时，我们将模型的输出与所有参考译文做比较，选择最匹配模型输出的一个译文来训练模型。实验结果表明，我们的方法在多个数据集上均取得了显著的提升，达到了目前非自回归模型中最先进的性能。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 3,
          day: "18",
          date: "2023-03",
          title: "NLP组7篇论文被ACL 2022接收",
          profile:
            "课题组今年有7篇论文被ACL 2022接收， 其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The 60th Annual Meeting of the Association for Computational Linguistics，是自然语言处理领域国际顶级会议之一；Findings of ACL是ACL 2021引入的在线附属出版物。",
          detail:
            "神经网络模型在新数据集上训练时，通常会逐渐遗忘旧数据集上学到的知识，在持续学习中的这种现象被称为灾难性遗忘。然而，我们发现即使模型始终在同一数据集上训练，灾难性遗忘现象仍然存在，具体表现为模型对新接触的样本关注更多、对较早接触的样本关注更少，我们把这种在训练样本上的不均衡问题称为“非均衡训练”。通过实验验证，我们发现非均衡训练问题在神经网络模型广泛存在，在机器翻译任务上尤其严重。通过进一步分析，我们揭示了在机器翻译上广泛使用的检查点平均技术与非均衡训练问题的联系，并确认了非均衡训练问题会对模型性能造成影响。为缓解这一问题，我们提出了互补在线知识蒸馏技术，通过对数据集的互补切分来保证教师模型始终与学生模型互补，从而使模型能够均匀地从所有训练样本中学习。在多个机器翻译任务上的实验表明，我们的方法成功地缓解了非均衡训练问题，取得了显著的性能提升。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
      ],
      // 所有的新闻
      newsAllList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "NLP组在EMNLP 2022会议上顺利举办讲习班",
          profile:
            "2022年12月，实验室题为《Non-Autoregressive Models for Fast Sequence Generation》的tutorial讲习班在EMNLP 2022会议上顺利举办。",
          detail:
            "本次讲习班时长3小时，由冯洋研究员和邵晨泽同学讲述非自回归序列生成模型的最新研究进展。非自回归序列生成模型是指并行解码生成整个序列的模型，它可以显著地加快序列生成的速度，已经在机器翻译、语音识别、语音合成等领域引起了广泛的关注。本次讲习班全面阐述了非自回归模型在序列生成中面临的多峰性挑战和目前的主流解决方案，例如知识蒸馏、增强表达能力、建模隐变量、改进训练目标、改进解码策略等，对非自回归模型在多种序列生成任务上的进展和它应用在不同任务时的共性和差异做了详细介绍，并展望了非自回归生成未来的发展方向。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NeurIPS 2022接收",
          profile:
            "2022年9月，自然语言处理组1篇论文被NeurIPS 2022接收。NeurIPS 2022的全称是Thirty-sixth Conference on Neural Information Processing Systems，是人工智能领域的顶级会议之一。NeurIPS 2022将于2022年11月28日-12月9日在美国新奥尔良举行。",
          detail:
            "非自回归翻译模型能够并行生成整句译文，在解码速度上具有非常大的优势，但由于交叉熵损失无法正确地评估模型的输出，非自回归模型的性能与自回归模型有很大差距。基于CTC损失的非自回归模型能够建模参考译文与模型输出的隐式对齐，因此大幅提升了非自回归模型的性能水平，目前已成为非自回归机器翻译的主流模型之一。然而，CTC损失最早是为语音识别任务设计的，只能建模参考译文与模型输出间的单调对齐，无法处理机器翻译中普遍存在的非单调对齐现象（如下图所示），这是非自回归机器翻译领域的一个open problem。在本文中，我们针对这个问题做了系统性的研究，将对齐空间扩展为非单调隐式对齐，并考虑所有与参考译文相关的对齐来计算损失。基于此，我们提出了基于二分图匹配和n元组匹配的两种解决方案，均能显著改善非自回归模型的翻译质量。在多个翻译数据集上，我们的最佳方法均达到了与自回归模型相当的性能，并保持着对自回归模型十倍以上的解码加速。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NAACL 2022接收",
          profile:
            "2022年4月，自然语言处理组1篇论文被NAACL 2022主会接收。NAACL 2022的全称是2022 Annual Conference of the North American Chapter of the Association for Computational Linguistics – Human Language Technologies (NAACL-HLT 2022)，是 ACL 的北美分会，自然语言处理领域的顶级会议之一。NAACL 2022将于2022年7月10日-15日在美国西雅图召开。",
          detail:
            "非自回归机器翻译模型存在多峰性问题：同一个源句可能有多个正确的译文，但模型只根据参考译文计算损失函数。对此，一种解决方案是序列级知识蒸馏，它通过将参考译文替换为自回归模型的输出，使目标端的译文更具确定性。然而，蒸馏后的数据集仍存在一定程度的多峰性，另外，向特定的自回归教师模型学习会限制模型能力的上限，从而约束了非自回归模型的潜力。在本文中，我们认为非自回归模型需要更多的参考译文来训练，并对此提出了多样蒸馏和译文选择的方法。具体地，我们首先通过不同随机种子训练多个教师模型，进行多样化的知识蒸馏，生成一个包含多个高质量参考译文的数据集。在训练非自回归模型时，我们将模型的输出与所有参考译文做比较，选择最匹配模型输出的一个译文来训练模型。实验结果表明，我们的方法在多个数据集上均取得了显著的提升，达到了目前非自回归模型中最先进的性能。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 3,
          day: "18",
          date: "2023-03",
          title: "NLP组7篇论文被ACL 2022接收",
          profile:
            "课题组今年有7篇论文被ACL 2022接收， 其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The 60th Annual Meeting of the Association for Computational Linguistics，是自然语言处理领域国际顶级会议之一；Findings of ACL是ACL 2021引入的在线附属出版物。",
          detail:
            "神经网络模型在新数据集上训练时，通常会逐渐遗忘旧数据集上学到的知识，在持续学习中的这种现象被称为灾难性遗忘。然而，我们发现即使模型始终在同一数据集上训练，灾难性遗忘现象仍然存在，具体表现为模型对新接触的样本关注更多、对较早接触的样本关注更少，我们把这种在训练样本上的不均衡问题称为“非均衡训练”。通过实验验证，我们发现非均衡训练问题在神经网络模型广泛存在，在机器翻译任务上尤其严重。通过进一步分析，我们揭示了在机器翻译上广泛使用的检查点平均技术与非均衡训练问题的联系，并确认了非均衡训练问题会对模型性能造成影响。为缓解这一问题，我们提出了互补在线知识蒸馏技术，通过对数据集的互补切分来保证教师模型始终与学生模型互补，从而使模型能够均匀地从所有训练样本中学习。在多个机器翻译任务上的实验表明，我们的方法成功地缓解了非均衡训练问题，取得了显著的性能提升。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 4,
          day: "18",
          date: "2023-03",
          title: "NLP组在EMNLP 2022会议上顺利举办讲习班",
          profile:
            "2022年12月，实验室题为《Non-Autoregressive Models for Fast Sequence Generation》的tutorial讲习班在EMNLP 2022会议上顺利举办。",
          detail:
            "本次讲习班时长3小时，由冯洋研究员和邵晨泽同学讲述非自回归序列生成模型的最新研究进展。非自回归序列生成模型是指并行解码生成整个序列的模型，它可以显著地加快序列生成的速度，已经在机器翻译、语音识别、语音合成等领域引起了广泛的关注。本次讲习班全面阐述了非自回归模型在序列生成中面临的多峰性挑战和目前的主流解决方案，例如知识蒸馏、增强表达能力、建模隐变量、改进训练目标、改进解码策略等，对非自回归模型在多种序列生成任务上的进展和它应用在不同任务时的共性和差异做了详细介绍，并展望了非自回归生成未来的发展方向。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 5,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NeurIPS 2022接收",
          profile:
            "2022年9月，自然语言处理组1篇论文被NeurIPS 2022接收。NeurIPS 2022的全称是Thirty-sixth Conference on Neural Information Processing Systems，是人工智能领域的顶级会议之一。NeurIPS 2022将于2022年11月28日-12月9日在美国新奥尔良举行。",
          detail:
            "非自回归翻译模型能够并行生成整句译文，在解码速度上具有非常大的优势，但由于交叉熵损失无法正确地评估模型的输出，非自回归模型的性能与自回归模型有很大差距。基于CTC损失的非自回归模型能够建模参考译文与模型输出的隐式对齐，因此大幅提升了非自回归模型的性能水平，目前已成为非自回归机器翻译的主流模型之一。然而，CTC损失最早是为语音识别任务设计的，只能建模参考译文与模型输出间的单调对齐，无法处理机器翻译中普遍存在的非单调对齐现象（如下图所示），这是非自回归机器翻译领域的一个open problem。在本文中，我们针对这个问题做了系统性的研究，将对齐空间扩展为非单调隐式对齐，并考虑所有与参考译文相关的对齐来计算损失。基于此，我们提出了基于二分图匹配和n元组匹配的两种解决方案，均能显著改善非自回归模型的翻译质量。在多个翻译数据集上，我们的最佳方法均达到了与自回归模型相当的性能，并保持着对自回归模型十倍以上的解码加速。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 6,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NAACL 2022接收",
          profile:
            "2022年4月，自然语言处理组1篇论文被NAACL 2022主会接收。NAACL 2022的全称是2022 Annual Conference of the North American Chapter of the Association for Computational Linguistics – Human Language Technologies (NAACL-HLT 2022)，是 ACL 的北美分会，自然语言处理领域的顶级会议之一。NAACL 2022将于2022年7月10日-15日在美国西雅图召开。",
          detail:
            "非自回归机器翻译模型存在多峰性问题：同一个源句可能有多个正确的译文，但模型只根据参考译文计算损失函数。对此，一种解决方案是序列级知识蒸馏，它通过将参考译文替换为自回归模型的输出，使目标端的译文更具确定性。然而，蒸馏后的数据集仍存在一定程度的多峰性，另外，向特定的自回归教师模型学习会限制模型能力的上限，从而约束了非自回归模型的潜力。在本文中，我们认为非自回归模型需要更多的参考译文来训练，并对此提出了多样蒸馏和译文选择的方法。具体地，我们首先通过不同随机种子训练多个教师模型，进行多样化的知识蒸馏，生成一个包含多个高质量参考译文的数据集。在训练非自回归模型时，我们将模型的输出与所有参考译文做比较，选择最匹配模型输出的一个译文来训练模型。实验结果表明，我们的方法在多个数据集上均取得了显著的提升，达到了目前非自回归模型中最先进的性能。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 7,
          day: "18",
          date: "2023-03",
          title: "NLP组7篇论文被ACL 2022接收",
          profile:
            "课题组今年有7篇论文被ACL 2022接收， 其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The 60th Annual Meeting of the Association for Computational Linguistics，是自然语言处理领域国际顶级会议之一；Findings of ACL是ACL 2021引入的在线附属出版物。",
          detail:
            "神经网络模型在新数据集上训练时，通常会逐渐遗忘旧数据集上学到的知识，在持续学习中的这种现象被称为灾难性遗忘。然而，我们发现即使模型始终在同一数据集上训练，灾难性遗忘现象仍然存在，具体表现为模型对新接触的样本关注更多、对较早接触的样本关注更少，我们把这种在训练样本上的不均衡问题称为“非均衡训练”。通过实验验证，我们发现非均衡训练问题在神经网络模型广泛存在，在机器翻译任务上尤其严重。通过进一步分析，我们揭示了在机器翻译上广泛使用的检查点平均技术与非均衡训练问题的联系，并确认了非均衡训练问题会对模型性能造成影响。为缓解这一问题，我们提出了互补在线知识蒸馏技术，通过对数据集的互补切分来保证教师模型始终与学生模型互补，从而使模型能够均匀地从所有训练样本中学习。在多个机器翻译任务上的实验表明，我们的方法成功地缓解了非均衡训练问题，取得了显著的性能提升。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 8,
          day: "18",
          date: "2023-03",
          title: "NLP组在EMNLP 2022会议上顺利举办讲习班",
          profile:
            "2022年12月，实验室题为《Non-Autoregressive Models for Fast Sequence Generation》的tutorial讲习班在EMNLP 2022会议上顺利举办。",
          detail:
            "本次讲习班时长3小时，由冯洋研究员和邵晨泽同学讲述非自回归序列生成模型的最新研究进展。非自回归序列生成模型是指并行解码生成整个序列的模型，它可以显著地加快序列生成的速度，已经在机器翻译、语音识别、语音合成等领域引起了广泛的关注。本次讲习班全面阐述了非自回归模型在序列生成中面临的多峰性挑战和目前的主流解决方案，例如知识蒸馏、增强表达能力、建模隐变量、改进训练目标、改进解码策略等，对非自回归模型在多种序列生成任务上的进展和它应用在不同任务时的共性和差异做了详细介绍，并展望了非自回归生成未来的发展方向。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 9,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NeurIPS 2022接收",
          profile:
            "2022年9月，自然语言处理组1篇论文被NeurIPS 2022接收。NeurIPS 2022的全称是Thirty-sixth Conference on Neural Information Processing Systems，是人工智能领域的顶级会议之一。NeurIPS 2022将于2022年11月28日-12月9日在美国新奥尔良举行。",
          detail:
            "非自回归翻译模型能够并行生成整句译文，在解码速度上具有非常大的优势，但由于交叉熵损失无法正确地评估模型的输出，非自回归模型的性能与自回归模型有很大差距。基于CTC损失的非自回归模型能够建模参考译文与模型输出的隐式对齐，因此大幅提升了非自回归模型的性能水平，目前已成为非自回归机器翻译的主流模型之一。然而，CTC损失最早是为语音识别任务设计的，只能建模参考译文与模型输出间的单调对齐，无法处理机器翻译中普遍存在的非单调对齐现象（如下图所示），这是非自回归机器翻译领域的一个open problem。在本文中，我们针对这个问题做了系统性的研究，将对齐空间扩展为非单调隐式对齐，并考虑所有与参考译文相关的对齐来计算损失。基于此，我们提出了基于二分图匹配和n元组匹配的两种解决方案，均能显著改善非自回归模型的翻译质量。在多个翻译数据集上，我们的最佳方法均达到了与自回归模型相当的性能，并保持着对自回归模型十倍以上的解码加速。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 10,
          day: "18",
          date: "2023-03",
          title: "NLP组1篇论文被NAACL 2022接收",
          profile:
            "2022年4月，自然语言处理组1篇论文被NAACL 2022主会接收。NAACL 2022的全称是2022 Annual Conference of the North American Chapter of the Association for Computational Linguistics – Human Language Technologies (NAACL-HLT 2022)，是 ACL 的北美分会，自然语言处理领域的顶级会议之一。NAACL 2022将于2022年7月10日-15日在美国西雅图召开。",
          detail:
            "非自回归机器翻译模型存在多峰性问题：同一个源句可能有多个正确的译文，但模型只根据参考译文计算损失函数。对此，一种解决方案是序列级知识蒸馏，它通过将参考译文替换为自回归模型的输出，使目标端的译文更具确定性。然而，蒸馏后的数据集仍存在一定程度的多峰性，另外，向特定的自回归教师模型学习会限制模型能力的上限，从而约束了非自回归模型的潜力。在本文中，我们认为非自回归模型需要更多的参考译文来训练，并对此提出了多样蒸馏和译文选择的方法。具体地，我们首先通过不同随机种子训练多个教师模型，进行多样化的知识蒸馏，生成一个包含多个高质量参考译文的数据集。在训练非自回归模型时，我们将模型的输出与所有参考译文做比较，选择最匹配模型输出的一个译文来训练模型。实验结果表明，我们的方法在多个数据集上均取得了显著的提升，达到了目前非自回归模型中最先进的性能。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 11,
          day: "18",
          date: "2023-03",
          title: "NLP组7篇论文被ACL 2022接收",
          profile:
            "课题组今年有7篇论文被ACL 2022接收， 其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The 60th Annual Meeting of the Association for Computational Linguistics，是自然语言处理领域国际顶级会议之一；Findings of ACL是ACL 2021引入的在线附属出版物。",
          detail:
            "神经网络模型在新数据集上训练时，通常会逐渐遗忘旧数据集上学到的知识，在持续学习中的这种现象被称为灾难性遗忘。然而，我们发现即使模型始终在同一数据集上训练，灾难性遗忘现象仍然存在，具体表现为模型对新接触的样本关注更多、对较早接触的样本关注更少，我们把这种在训练样本上的不均衡问题称为“非均衡训练”。通过实验验证，我们发现非均衡训练问题在神经网络模型广泛存在，在机器翻译任务上尤其严重。通过进一步分析，我们揭示了在机器翻译上广泛使用的检查点平均技术与非均衡训练问题的联系，并确认了非均衡训练问题会对模型性能造成影响。为缓解这一问题，我们提出了互补在线知识蒸馏技术，通过对数据集的互补切分来保证教师模型始终与学生模型互补，从而使模型能够均匀地从所有训练样本中学习。在多个机器翻译任务上的实验表明，我们的方法成功地缓解了非均衡训练问题，取得了显著的性能提升。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
      ],
    };
  },
  created() {
    // let id = this.$route.query.id;
    // console.log(id);
    // 其实应该先从后端获取数据将数据传到newsAllList数组里面
    // 创建的时候就会把总共的数目传进来
    this.total_number = this.newsAllList.length;
    // slice函数包含前面的,不含后面的
    this.newsList = this.newsAllList.slice(
      (this.current_index - 1) * 5,
      this.current_index * 5
    );
  },
  methods: {
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.newsList = this.newsAllList.slice((val - 1) * 5, val * 5);
    },
    gotoDetail(item) {
      this.$router.push({
        path: "/activity/academyDetail",
        name: "学术动态详情",
        // 用query传参,在地址栏后面加东西如 ?id=1这种跟在网址后面
        query: {
          // 传参数的时候注意将对象转化成字符串并且加密,在接收端使用解析
          // 如果不这样做的话就会导致,刷新一下传参的东西解析不了
          item: encodeURIComponent(JSON.stringify(item)),
        },
      });
    },
  },
};
</script>
<style scoped>
/* PC端 */
@media screen and (min-width: 1000px) {
  .academy {
    padding: 3rem 0;
    background: #eef7fe;
  }
  .academyContent {
    width: 75%;
    margin: 0 auto;
    padding: 0 3rem;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .academyTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }

  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }
  /* 设置块和分页的距离 */
  .academyItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
  .academy-row {
    height: 80px;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 20px 0;
    border-bottom: 1px solid #dfdfdf;
    transition: all 0.5s;
  }
  /* 时间框 */
  .academy-date {
    width: 80px;
    height: 80px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background: #008cd6;
    border-radius: 6px;
    color: #ffffff;
    font-family: Arial;
    text-align: center;
    transition: all 0.5s;
  }
  /* 就是日期中有个要变大 */
  .academy-row .academy-date div:first-child {
    font-size: 3rem;
    font-weight: bold;
  }
  /* 文字部分 */
  .academy-profile {
    width: 85%;
    height: 80px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
  .academy-title {
    margin-bottom: 0.5rem;
    font-size: 16px;
    font-weight: bold;
    color: #333333;
    text-align: left;
    overflow: hidden;
    transition: all 0.5s;
  }
  .academy-thing {
    font-size: 16px;
    color: #999999;
    text-align: left;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
  .academy-row:hover {
    border-bottom: 1px solid #0055a2;
  }
  .academy-row:hover .academy-title {
    color: #0055a2;
  }
  .academy-row:hover .academy-date {
    background-color: #0055a2;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .academy {
    background: #eef7fe;
  }
  .academyContent {
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .academyTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }

  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }
  /* 设置块和分页的距离 */
  .academyItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
  .academy-row {
    height: 8rem;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
    transition: all 0.5s;
  }
  /* 时间框 */
  .academy-date {
    width: 8rem;
    height: 8rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background: #008cd6;
    border-radius: 6px;
    color: #ffffff;
    font-family: Arial;
    text-align: center;
    transition: all 0.5s;
  }
  /* 就是日期中有个要变大 */
  .academy-row .academy-date div:first-child {
    font-size: 3rem;
    font-weight: bold;
  }
  /* 文字部分 */
  .academy-profile {
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
  .academy-title {
    margin-bottom: 0.5rem;
    font-size: 1.6rem;
    font-weight: bold;
    color: #333333;
    text-align: left;
    overflow: hidden;
    transition: all 0.5s;
  }
  .academy-thing {
    font-size: 1rem;
    color: #999999;
    text-align: left;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
  .academy-row:hover {
    border-bottom: 1px solid #0055a2;
  }
  .academy-row:hover .academy-title {
    color: #0055a2;
  }
  .academy-row:hover .academy-date {
    background-color: #0055a2;
  }
}
</style>

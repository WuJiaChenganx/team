<template>
  <div class="academicTrend">
    <div class="academicTitle">
      <div class="left-title">学术动态</div>
      <a class="title-more" @click="goTo('/activity/academy')">更多 +</a>
    </div>
    <div class="academicContent">
      <div
        class="item-content"
        v-for="academyItem in newsList"
        :key="academyItem.id"
        style="cursor: pointer"
        @click="gotoDetail(academyItem)"
      >
        <div class="imgBox">
          <img :src="academyItem.picUrl" />
        </div>
        <div class="textItem">
          <div class="title-box">{{ academyItem.title }}</div>
          <div class="detail-box">
            {{ academyItem.profile }}
          </div>
          <div class="academicDate">
            {{ academyItem.date }}-{{ academyItem.day }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      // 要展示的新闻信息(加载前还要处理过)
      newsList: [
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
  methods: {
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
    goTo(path) {
      // 当前不一样就跳转
      if (this.$route.path !== path) {
        this.$router.push({
          path: path,
        });
      }
    },
  },
};
</script>
<style scoped>
.academicTitle {
  width: 100%;
  height: 3.8rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 2rem;
}
.academicTitle .left-title {
  text-align: left;
  font-size: 2.2rem;
  font-weight: bold;
  color: #003266;
}
.academicTitle .title-more {
  color: #7db0cb;
  font-size: 1.4rem;
  line-height: 1.8rem;
  cursor: pointer;
}
.academicContent {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-bottom: 2rem;
}
/* 每行的高 14rem(2rem的下外边距) 放图片和文字横着放*/
.item-content {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 2rem;
}
.imgBox {
  float: left;
  width: 20%;
  height: 14rem;
  overflow: hidden;
  box-sizing: border-box;
  border: 1px solid #eee;
}
.imgBox img {
  width: 100%;
  height: 100%;
}

.item-content:hover .imgBox img {
  transform: scale(1.1);
  transition: all 0.5s;
}

.item-content:hover .title-box {
  color: #ff2400;
}
.item-content:hover .academicDate {
  color: #0055a2;
}

.textItem {
  width: 78%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.title-box {
  text-align: left;
  color: #0055a2;
  font-size: 2rem;
  font-weight: bold;
}
/* 中间的profile */
.detail-box {
  color: #909090;
  font-size: 1.5rem;
  text-align: left;
  word-wrap: break-word;
  word-break: break-all;
  /* 显示3行 */
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
}
.academicDate {
  text-align: right;
  height: 22px;
  font-size: 1.5rem;
  font-family: Arial;
  color: #828282;
}
</style>

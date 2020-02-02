## introduction

In reinforcement learning(RL)[1], the agent learns and completes tasks by continuously interacting autonomously with its environment. During the interaction process, the agent will continuously optimize its strategy based on the goal of maximizing the cumulative feedback reward. 

The conventional RL algorithms try to learn a table that maps a given state to the long-term expected reward of each available action, which are classified as value-based methods. These tabular methods are commonly used in discrete cases, but some generalization techniques can be applied to approximate this value function to accommodate continuous  state and action spaces[2]. However, it usually produces corresponding generalization errors, making it difficult for us to get the optimal strategy even under simple tasks. For the continuous state space problem, Mnih et al. have proposed the DQN algorithm[3] that uses artificial neural networks to approximate state value functions, thereby avoiding dimensional disasters. Based on the DQN algorithm, scholars have proposed a series of improved algorithms: prioritized experience replay[4] assigns weight to experience based on the temporal difference(TD) error to improve learning efficiency; Dueling DQN[5] improves the network structure by decomposing the action value function into state value function V and advantage function A to improve Function approximation effect; Double DQN[6] implements action selection and action evaluation with different parameters to solve the overestimation problem; Retrace[7] modifies the calculation method of Q value to reduce the variance of value estimation; Noisy DQN[8] adds noise to network parameters and increases the degree of exploration; Distributed DQN[9] refines the estimate of the Q value into an estimate of the Q distribution.

Instead, the policy-based RL methods iteratively calculate the strategy directly, and iteratively update the strategy parameters until the cumulative return is maximized. In recent years, openAI, a well-known artificial intelligence research institution, has proposed many algorithms related to policy gradients: TRPO[10], PPO[11], etc. Compared with pure value-based methods, this type of method has simple strategy parameterization and better convergence properties, and is suitable for discrete and continuous action spaces. The disadvantages are that the trajectory variance is large, the sample utilization efficiency is low, and it is easy to converge to a local optimum.

As a result, the mix of value-based and policy-based approaches has gradually attracted widespread attention. In 2000, Konda et al. proposed an actor-critic(AC) model[12], which combines the advantages of the value-based method and the policy-based method: the value-based method is used to train the Q function to improve the sample utilization efficiency, and the policy-based method is used to train the strategy. This kind of method can be seen as an extension of the value-based method in the continuous action space, or as an improvement of the policy-based method to reduce the sampling variance. Although this type of method absorbs the advantages of both, it also inherits the corresponding disadvantages. For example, critical also has the problem of overestimation, and the actor has the problem of insufficient exploration. For these problem, many experts have proposed quite good improvements: A3C[13] implements AC algorithms asynchronously and parallelly,  disrupting the correlation between data and improving data collection and training speed; DDPG[14] inherits DQN's target network, and the actor is a deterministic strategy, which makes training more stable and simple; TD3[15] introduces Double DQN method and delayed update strategy to solve the overestimation problem; SAC[16] introduces entropy regularization in the Q value estimation to improve the exploration ability.

In a RL system, we usually design a reward function based on the specific task to provide instant feedback when the agent interacts with the environment. However, for most multi-step decision-making problems, it will be difficult for the environment to give an accurate and immediate feedback signal or the feedback signal given by the environment will have a high delay. This has gradually become the bottleneck of the application of RL in more complex problems. In response to the above situation, a more direct way is to use a large number of  expert decision data to learn an agent's strategy. This way of learning is called imitation learning[17]. Among them, inverse reinforcement learning(IRL) is a type of algorithm that inversely solves the feedback function in the Markov decision process based on the assumption that the expert's decision trajectory is optimal[18,19].

Analogous to RL, IRL is perceived both as a problem and as a class of methods. Many scholars are studying in its central challenges such as the difficulty in performing accurate inference[20] and its generalizability[21], its sensitivity to prior knowledge[22], and the disproportionate growth in solution complexity with problem size[23,24]. In addition, multiple reward function may appear when the experts make decisions on some complex tasks[19]. Therefore, experts will inevitably make certain trade-offs, which may make the final model tend to the local optimal situation. In response to this problem, we have previously studied the behavioral fusion method[25] that divides complex behavior into several basic behaviors, let them be trained separately by their simple feedback functions, and use the trained decision network to train complex behavior decision network, so as that decision-makers can avoid designing the complex feedback function and make the decision network converge well. In this paper, we propose a novel way to combine IRL and behavior fusion so that we can train an excellent reward function by the quite simple and optimal expert trajectory, and then train a more robust policy network. And our experiments also prove the feasibility and effectiveness of the method.

The remainder of this paper is organized as follows.





##reference

[1]Sutton R, Barto A. Reinforcement Learning: An Introduction[M]. Cambridge, MA: MIT Press, 2017
[2]Shi H, Li X, Hwang K S, et al. Decoupled Visual Servo- ing With Fuzzy Q-Learning. IEEE Transactions on Indus- trial Informatics 2018;14(1):241-252.
[3]
[4]
[5]
[6]
[7]
[8]
[9]
[10]
[11]
[12]
[13]
[14]
[15]
[16]
[17]Bagnell J. An invitation to imitation[OL]. 2015[2017-02-12]. 
[18]S. Russell, Learning agents for uncertain environments (extended abstract), in: Proceedings of the Eleventh Annual Conference on Computational Learning Theory, COLT’ 98, ACM, New York, NY, USA, 1998, pp. 101– 103.
[19]A. Ng, S. Russell, Algorithms for inverse reinforcement learning, Proceedings of the Seventeenth International Conference on Machine Learning 0 (2000) 663–670.
[20]P. Abbeel, A. Coates, M. Quigley, A. Y. Ng, An application of reinforcement learning to aerobatic helicopter flight, in: Proceedings of the 19th Inter- national Conference on Neural Information Processing Systems, NIPS’06, MIT Press, Cambridge, MA, USA, 2006, pp. 1–8.
[21]T. Munzer, B. Piot, M. Geist, O. Pietquin, M. Lopes, Inverse reinforcement learning in relational domains, in: Proceedings of the 24th International Conference on Artificial Intelligence, IJCAI’15, AAAI Press, 2015, pp. 3735–3741.
[22]G. Neu, C. Szepesva ́ri, Apprenticeship Learning using Inverse Reinforcement Learning and Gradient Methods, Twenty-Third Conference on Uncertainty in Artificial Intelligence (2007) 295–302arXiv:1206.5264.
[23]D. Ramachandran, E. Amir, Bayesian inverse reinforcement learning, in: Proceedings of the 20th International Joint Conference on Artifical Intel- ligence, IJCAI’07, Morgan Kaufmann Publishers Inc., San Francisco, CA, USA, 2007, pp. 2586–2591.
[24]A. Boularias, J. Kober, J. Peters, Relative entropy inverse reinforcement learning, in: Proceedings of the Fourteenth International Conference on Artificial Intelligence and Statistics, AISTATS 2011, Fort Lauderdale, USA, April 11-13, 2011, 2011, pp. 182–189.
[25]



<style>
    v-img {
        width:20%;
        height:20%;
        }
</style>

<template>
  <div>
    <sidebar-menu :menu="menu" />
    <v-img  src="@/assets/puzzle2.png" ></v-img>
  </div>
</template>

<script>
    export default {
        data() {
            return {
                menu: [
                    {
                        header: true,
                        title: 'M  E  N  U',
                        hiddenOnCollapse: true
                    },
                    {
                        href: '/',
                        title: 'H O M E',
                        icon: 'fa fa-user'
                    },
                    {
                        href: '/',
                        title: 'L O G I N',
                        icon: 'fa fa-chart-area',
                        child: [
                            {
                                href: '/AdminSetupPage',
                                title: 'R E G I S T E R'
                            },
                            {
                                href: '/LoginPage',
                                title: 'L O G I N'
                            }
                        ]
                    },
                    {
                        href: '/VuetifyBoardListPage',
                        title: 'U S E R',
                        icon: 'fa fa-chart-area',
                    },
                    {
                        href: '/Puzzle',
                        title: 'P U Z Z L E',
                        icon: 'fa fa-chart-area',
                    },
                    {
                        href: '/RankListPage',
                        title: 'R A N K',
                        icon: 'fa fa-chart-area',
                    },
                ]
            }
        }
    }
</script>
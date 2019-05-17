package com.spendster.presentation.homeScreen.Dashboard;

public class DashboardPresenter {
    private final DashboardView dashboardView;
    private final DashboardModel dashboardModel;

    public DashboardPresenter(DashboardView dashboardView, DashboardModel dashboardModel) {
        this.dashboardView = dashboardView;
        this.dashboardModel = dashboardModel;
    }

    public void fetchExpenses(){
        if (dashboardView != null){
            if (dashboardModel != null){
                dashboardView.bindExpenses(dashboardModel.getExpenses());
            }
        }
    }
}
